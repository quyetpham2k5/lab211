/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrixcalculator;



import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            printMenu();
            int choice = readIntInRange("Choose an option [1-4]: ", 1, 4);
            switch (choice) {
                case 1:
                    handleAdd();
                    break;
                case 2:
                    handleSubtract();
                    break;
                case 3:
                    handleMultiply();
                    break;
                case 4:
                    System.out.println("Exit program. Bye!");
                    return;
                default:
                    // never reach because of validation
                    break;
            }
            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("===== MATRIX CALCULATOR =====");
        System.out.println("1. Addition matrices");
        System.out.println("2. Subtraction matrices");
        System.out.println("3. Multiplication matrices");
        System.out.println("4. Exit");
    }

    private void handleAdd() {
        System.out.println("\n-- Addition --");
        Matrix a = MatrixIO.readMatrix(scanner, "A");
        Matrix b = MatrixIO.readMatrix(scanner, "B");
        try {
            Matrix result = a.additionMatrix(b); // theo yêu cầu đề:contentReference[oaicite:4]{index=4}
            System.out.println("Result:");
            MatrixIO.printMatrix(result);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void handleSubtract() {
        System.out.println("\n-- Subtraction --");
        Matrix a = MatrixIO.readMatrix(scanner, "A");
        Matrix b = MatrixIO.readMatrix(scanner, "B");
        try {
            Matrix result = a.subtractionMatrix(b); // theo yêu cầu đề:contentReference[oaicite:5]{index=5}
            System.out.println("Result:");
            MatrixIO.printMatrix(result);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void handleMultiply() {
        System.out.println("\n-- Multiplication --");
        Matrix a = MatrixIO.readMatrix(scanner, "A");
        Matrix b = MatrixIO.readMatrix(scanner, "B");
        try {
            Matrix result = a.multiplicationMatrix(b); // theo yêu cầu đề:contentReference[oaicite:6]{index=6}
            System.out.println("Result:");
            MatrixIO.printMatrix(result);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.printf("Please enter a number in range [%d..%d].%n", min, max);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}
