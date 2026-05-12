package org.example;

/**
 * Виконавчий клас, що містить логіку обробки матриць.
 */
public class MatrixOperations {

    // Метод для множення матриць
    public Matrix multiply(Matrix a, Matrix b) {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("Розмірності матриць несумісні для виконання множення");
        }
        // Створюємо масив для результату:
        int[][] result = new int[a.getRows()][b.getCols()];
        // Проходимо по рядках першої матриці.
        for (int i = 0; i < a.getRows(); i++) {
            // Проходимо по стовпцях другої матриці
            for (int j = 0; j < b.getCols(); j++) {
                // Виконуємо обчислення
                for (int k = 0; k < a.getCols(); k++) {
                    // Накопичення суми добутків елементів рядка на стовпець
                    result[i][j] += a.getElement(i, k) * b.getElement(k, j);
                }
            }
        }
        return new Matrix(result);
    }

    // Метод для обчислення суми
    public int calculateSpecialSum(Matrix c) {
        int totalSum = 0;

        for (int j = 0; j < c.getCols(); j++) {
            int columnNumber = j + 1; // Порядковий номер стовпця

            if (columnNumber % 2 != 0) {
                // Пошук максимального значення елемента у непарному стовпці
                int max = c.getElement(0, j); // Беремо перший елемент стовпця
                for (int i = 1; i < c.getRows(); i++) { // Починаємо з другого елемента
                    if (c.getElement(i, j) > max) {
                        max = c.getElement(i, j);
                    }
                }
                totalSum += max;
            }
            else
            {
                // Пошук мінімального значення елемента у парному стовпці
                int min = c.getElement(0, j); // Беремо перший елемент стовпця
                for (int i = 1; i < c.getRows(); i++) { // Починаємо з другого елемента
                    if (c.getElement(i, j) < min) {
                        min = c.getElement(i, j);
                    }
                }
                totalSum += min; // Додаємо знайдений мінімум до загального результату.
            }
        }
        return totalSum;
    }
}