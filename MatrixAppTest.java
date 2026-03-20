import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixAppTest {

    @Test
    void testMultiplyMatrices() {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] expected = {{19, 22}, {43, 50}};

        assertArrayEquals(expected, MatrixApp.multiplyMatrices(a, b));
    }

    @Test
    void testCalculateSpecialSum() {
        int[][] matrix = {
                {1, 10},
                {5, 2}
        };
        assertEquals(11, MatrixApp.calculateSpecialSum(matrix));
    }

    @Test
    void testErrorHandling() {
        int[][] a = {{1, 2}};
        int[][] b = {{1}};
        assertThrows(IllegalArgumentException.class, () -> MatrixApp.multiplyMatrices(a, b));
    }
}