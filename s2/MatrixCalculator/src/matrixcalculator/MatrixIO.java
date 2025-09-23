/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrixcalculator;



import java.util.Scanner;

public class MatrixIO {

    public static Matrix readMatrix(Scanner scanner, String name) {
        int rows = readPositiveInt(scanner, "Enter number of rows for matrix " + name + ": ");
        int cols = readPositiveInt(scanner, "Enter number of columns for matrix " + name + ": ");
        Matrix m = new Matrix(rows, cols);
        System.out.printf("Enter values for matrix %s (%d x %d):%n", name, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double value = readDoubleOrReject(scanner,
                        String.format("  [%d,%d] = ", i, j));
                m.setValue(i, j, value);
            }
        }
        return m;
    }

    public static void printMatrix(Matrix m) {
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                System.out.print(trimTrailingZeros(m.getValue(i, j)) + (j == m.getCols() - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                // Không đúng số → yêu cầu nhập lại
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    // Nếu người dùng nhập không phải số → IN ĐÚNG THÔNG BÁO theo đề: 
    // "Values of matrix must be the number":contentReference[oaicite:11]{index=11}
    private static double readDoubleOrReject(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Values of matrix must be the number");
            }
        }
    }

    private static String trimTrailingZeros(double d) {
        String s = Double.toString(d);
        if (s.contains(".")) {
            // remove trailing zeros and possible trailing dot
            s = s.replaceAll("\\.?0+$", "");
        }
        return s;
    }
}
