import java.util.Arrays;
import java.util.Scanner;

public class lab1 {

    public static void main(String[] args) {
        try {
            // Задаємо параметри матриць
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of rows: ");
            int rows = scanner.nextInt();

            System.out.print("Enter the number of columns: ");
            int columns = scanner.nextInt();

            float[][] matrixB = new float[rows][columns];

            System.out.println("Enter elements of matrix B:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.printf("B[%d][%d]: ", i, j);
                    matrixB[i][j] = scanner.nextFloat();
                }
            }

            System.out.print("Enter the constant 'a': ");
            float a = scanner.nextFloat();

            // Створюємо об'єкт класу та виконуємо обчислення
            lab1 lab1 = new lab1();
            float[][] matrixC = lab1.multiplyMatrixByConstant(matrixB, a);
            System.out.println("Matrix C (result of multiplication): ");
            lab1.printMatrix(matrixC);

            float[] columnAverages = lab1.calculateColumnAverages(matrixC);
            System.out.println("Column averages: " + Arrays.toString(columnAverages));

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Множить константу на матрицю
     *
     * @param matrix вхідна матриця
     * @param constant вхідна константа
     * @return вихідна матриця
     */
    public float[][] multiplyMatrixByConstant(float[][] matrix, float constant) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        float[][] result = new float[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }

        return result;
    }

    /**
     * Рахує середнє значення елементів кожного стовпчика матриця.
     *
     * @param matrix вхідна матриця
     * @return масив, що містить середнє значення кожного елементу
     */
    public float[] calculateColumnAverages(float[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        float[] averages = new float[columns];

        for (int j = 0; j < columns; j++) {
            float sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += matrix[i][j];
            }
            averages[j] = sum / rows;
        }

        return averages;
    }

    /**
     * Вивід матриці в конслоль
     *
     * @param matrix матриця, яку ми будемо виводити
     */
    public void printMatrix(float[][] matrix) {
        for (float[] row : matrix) {
            for (float element : row) {
                System.out.printf("%.2f ", element);
            }
            System.out.println();
        }
    }
}
