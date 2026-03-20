public class MatrixApp {

    public static void main(String[] args) {
        try {
            int[][] matrixA = {
                    {1, 2, 3},
                    {4, 5, 6}
            };

            int[][] matrixB = {
                    {7, 8},
                    {9, 10},
                    {11, 12}
            };

            int[][] matrixC = multiplyMatrices(matrixA, matrixB);
            System.out.println("Результат множення (Матриця C):");
            printMatrix(matrixC);

            int resultSum = calculateSpecialSum(matrixC);
            System.out.println("Сума за варіантом: " + resultSum);

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            throw new IllegalArgumentException("Матриця порожня");
        }
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("Неправильні розміри для множення");
        }

        int rows = a.length;
        int cols = b[0].length;
        int commonDim = b.length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < commonDim; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static int calculateSpecialSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матриця порожня");
        }

        int totalSum = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            if (j % 2 != 0) {
                int max = matrix[0][j];
                for (int i = 1; i < rows; i++) {
                    if (matrix[i][j] > max) max = matrix[i][j];
                }
                totalSum += max;
            } else {
                int min = matrix[0][j];
                for (int i = 1; i < rows; i++) {
                    if (matrix[i][j] < min) min = matrix[i][j];
                }
                totalSum += min;
            }
        }
        return totalSum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}