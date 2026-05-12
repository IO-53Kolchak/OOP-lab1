package org.example;

/**
 * Клас для візуалізації матриць.
 */
public class MatrixPrint {

    /**
     * Виводить матрицю у консоль.
     * @param m матриця для виводу
     */
    public void print(Matrix m) {
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                // Використовуємо форматований вивід для рівних колонок
                System.out.printf("%d\t", m.getElement(i, j));
            }
            System.out.println();
        }
    }
}