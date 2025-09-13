/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1;


import java.util.Scanner;

/**
 * Main: chương trình chính cho Base Converter
 * - Cho phép chọn hệ cơ số đầu vào, đầu ra
 * - Nhập giá trị cần đổi
 * - Xuất ra kết quả
 * - Lặp lại cho đến khi người dùng thoát
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseConverter converter = new BaseConverter();

        while (true) {
            System.out.println("===== BASE CONVERTER =====");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Hexadecimal");
            System.out.println("4. Exit");

            System.out.print("Choose input base (1-3, 4 to exit): ");
            int inChoice = sc.nextInt();
            if (inChoice == 4) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.print("Choose output base (1-3): ");
            int outChoice = sc.nextInt();

            int baseIn = getBase(inChoice);
            int baseOut = getBase(outChoice);

            sc.nextLine(); // clear buffer
            System.out.print("Enter value: ");
            String value = sc.nextLine().trim();

            try {
                String result = converter.convert(value, baseIn, baseOut);
                System.out.println("Result: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for the selected base!");
            }

            System.out.println();
        }

        sc.close();
    }

    // Map số lựa chọn sang hệ cơ số
    private static int getBase(int choice) {
        switch (choice) {
            case 1: return 2;
            case 2: return 10;
            case 3: return 16;
            default: return 10;
        }
    }
}
