package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            MatrixOperations ops = new MatrixOperations();
            MatrixPrint printer = new MatrixPrint();

            // Вхідні дані
            Matrix a = new Matrix(new int[][] {
                    {1, 3},
                    {2, 4}
            });

            Matrix b = new Matrix(new int[][] {
                    {5, 6},
                    {7, 8}
            });

            // Виконуємо першу дію (множення)
            Matrix c = ops.multiply(a, b);

            // Виводимо результат першої дії
            System.out.println("Результат першої дії \n(Матриця C):");
            printer.print(c);

            // Виконуємо другу дію
            int result = ops.calculateSpecialSum(c);
            System.out.println("\nРезультат другої дії (Сума найбільших елементів " +
                    "непарних стовпців та найменших парних): " + result);

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}