/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1;



import java.util.List;
import java.util.Scanner;

/**
 * Giao diện console theo đúng mô tả đề:
 * - Hiển thị menu
 * - Nhập hệ số với validate: nếu gõ chữ -> "Please input number" và nhập lại
 * - Giải và in nghiệm
 * - In Odd/Even/Perfect Square từ các hệ số đã nhập
 * - Lặp đến khi người dùng chọn Exit
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EquationSolver solver = new EquationSolver();
        Number numberUtil = new Number();

        while (true) {
            System.out.println("========= Equation Program =========");
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            System.out.print("Please choice one option: ");

            int choice = readMenuChoice(sc);

            if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("----- Calculate Equation -----");
                    float a = readFloat(sc, numberUtil, "Enter A: ");
                    float b = readFloat(sc, numberUtil, "Enter B: ");

                    List<Float> r1 = solver.calculateEquation(a, b);
                    if (r1 == null) {
                        System.out.println("No solution.");
                    } else if (r1.isEmpty()) {
                        System.out.println("Infinite solutions.");
                    } else {
                        System.out.printf("Solution: x = %.3f%n", r1.get(0));
                    }
                    displayEvenOddSquare(numberUtil, new float[]{a, b});
                    break;

                case 2:
                    System.out.println("----- Calculate Quadratic Equation -----");
                    float qa = readFloat(sc, numberUtil, "Enter A: ");
                    float qb = readFloat(sc, numberUtil, "Enter B: ");
                    float qc = readFloat(sc, numberUtil, "Enter C: ");

                    List<Float> r2 = solver.calculateQuadraticEquation(qa, qb, qc);
                    if (r2 == null) {
                        System.out.println("No solution.");
                    } else if (r2.isEmpty()) {
                        System.out.println("Infinite solutions.");
                    } else if (r2.size() == 1) {
                        System.out.printf("Solution: x = %.3f%n", r2.get(0));
                    } else {
                        System.out.printf("Solution: x1 = %.3f and x2 = %.3f%n", r2.get(0), r2.get(1));
                    }
                    displayEvenOddSquare(numberUtil, new float[]{qa, qb, qc});
                    break;

                default:
                    System.out.println("Invalid option!");
            }
            System.out.println();
        }

        sc.close();
    }

    // Đọc lựa chọn menu an toàn (1-3), sai thì yêu cầu nhập lại
    private static int readMenuChoice(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                int c = Integer.parseInt(line);
                if (c >= 1 && c <= 3) return c;
            } catch (NumberFormatException ignored) { }
            System.out.print("Please choice one option: ");
        }
    }

    // Đọc 1 số float với thông báo "Please input number" nếu nhập sai
    private static float readFloat(Scanner sc, Number util, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            Float v = util.checkin(s);
            if (v != null) return v;
            System.out.println("Please input number");
        }
    }

    // In chẵn/lẻ/chính phương theo ví dụ định dạng trong đề
    private static void displayEvenOddSquare(Number util, float[] nums) {
        // Even
        System.out.print("Number is Even:");
        for (float n : nums) {
            if (util.isEven(n)) System.out.print(n + ", ");
        }
        System.out.println();

        // Odd
        System.out.print("Odd Number(s):");
        for (float n : nums) {
            if (util.isOdd(n)) System.out.print(n + ", ");
        }
        System.out.println();

        // Perfect Square
        System.out.print("Number is Perfect Square:");
        for (float n : nums) {
            if (util.isPerfectSquare(n)) System.out.print(n + ", ");
        }
        System.out.println();
    }
}
