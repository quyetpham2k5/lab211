/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1;



import java.util.Scanner;

/**
 * Main: nhập dữ liệu và hiển thị kết quả tìm kiếm
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số phần tử
        System.out.print("Enter number of array: ");
        int n = readPositiveInt(sc);

        // Tạo mảng và sinh số ngẫu nhiên
        LinearSearch ls = new LinearSearch(n);
        ls.fillRandom();

        // Nhập giá trị cần tìm
        System.out.print("Enter search value: ");
        int key = sc.nextInt();

        // In mảng
        System.out.println("The array: " + ls.showArray());

        // Tìm và in kết quả
        int idx = ls.findIndex(key);
        if (idx != -1) {
            System.out.println("Found " + key + " at index: " + idx);
        } else {
            System.out.println(key + " is not found in array.");
        }

        sc.close();
    }

    // Hàm đọc số nguyên dương
    private static int readPositiveInt(Scanner sc) {
        int x;
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a positive integer: ");
                sc.next();
            }
            x = sc.nextInt();
            if (x > 0) return x;
            System.out.print("Please enter a positive integer: ");
        }
    }
}
