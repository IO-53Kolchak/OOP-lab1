package org.example;

/**
 * Клас, що представляє матрицю цілих чисел.
 */
public class Matrix {
    private final int[][] data;
    private final int rows;
    private final int cols;

    public Matrix(int[][] data) {
        // Перевірка на null або порожній масив
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Матриця не може бути порожньою");
        }
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new int[rows][cols];
        // Копіюємо кожен рядок окремо
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }
    /**
     * Геттери, повертають значення елемента
     * @param row індекс рядка
     * @param col індекс стовпця
     * @return значення елемента
     */
    public int getElement(int row, int col) {
        return data[row][col];
    }

    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }
}
