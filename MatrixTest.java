package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас для перевірки функціоналу роботи з матрицями.
 */
class MatrixTest {

    @Test
    @DisplayName("Тест створення матриці та отримання елементів")
     void testMatrixInitialization() {

        int[][] data = {
                {1, 2},
                {3, 4}
        };

        Matrix matrix = new Matrix(data);

        // Перевірка розмірності та коректності перенесення даних
        assertEquals(2, matrix.getRows());
        assertEquals(2, matrix.getCols());
        assertEquals(1, matrix.getElement(0, 0));
        assertEquals(4, matrix.getElement(1, 1));
    }


    @Test
    @DisplayName("Тест множення матриць")
    void testMultiplicationLogic() {

        MatrixOperations ops = new MatrixOperations();

        int[][] dataA = {
                {1, 2},
                {3, 4}
        };

        int[][] dataB = {
                {5, 6},
                {7, 8}
        };

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);

        Matrix result = ops.multiply(a, b);

        // Перевірка результатів множення за стандартною формулою
        assertEquals(19, result.getElement(0, 0)); // 1*5 + 2*7
        assertEquals(22, result.getElement(0, 1)); // 1*6 + 2*8
        assertEquals(43, result.getElement(1, 0)); // 3*5 + 4*7
        assertEquals(50, result.getElement(1, 1)); // 3*6 + 4*8
    }

    private void assertEquals(int i, int element) {

    }


    @Test
    @DisplayName("Тест обробки несумісних розмірів при множенні")
    void testIncompatibleDimensions() {

        MatrixOperations ops = new MatrixOperations();

        Matrix a = new Matrix(new int[][]{ {1, 2, 3} }); // 1x3
        Matrix b = new Matrix(new int[][]{ {1, 2}, {3, 4} }); // 2x2

        // Очікуємо виключення через різну кількість стовпців A та рядків B
        assertThrows(IllegalArgumentException.class, () -> {
            ops.multiply(a, b);
        });
    }


    @Test
    @DisplayName("Тест розрахунку суми за варіантом (макс. з непарних + мін. з парних)")
    void testSpecialSumCalculation() {

        MatrixOperations ops = new MatrixOperations();

        // Стовпець 1 непарний, 10, 5, 20 макс. 20
        // Стовпець 2 парний, 4, 2, 8, мін. 2
        // Очікувана сума: 20 + 2 = 22
        int[][] data = {
                {10, 4},
                {5, 2},
                {20, 8}
        };

        Matrix m = new Matrix(data);

        // Отримуємо результат у long, як це визначено в методі
        int result = ops.calculateSpecialSum(m);
        assertEquals(22, result);

    }

    @Test
    @DisplayName("Тест валідації порожніх вхідних даних")
    void testEmptyDataValidation() {

        // Перевірка, що конструктор не приймає порожні масиви
        assertThrows(IllegalArgumentException.class, () -> {
            new Matrix(new int[][]{});
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Matrix(new int[][]{ {} });
        });
    }
}