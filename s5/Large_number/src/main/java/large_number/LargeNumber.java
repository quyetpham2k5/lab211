/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package large_number;
import java.util.Scanner;

public class LargeNumber {
    private int[] digits; // mảng lưu từng chữ số
    private int length;   // số lượng chữ số thực tế

    public LargeNumber() {
        this.digits = new int[0];
        this.length = 0;
    }
    public void input(Scanner sc, String name) {
        while (true) {
            System.out.print("Enter " + name + ": ");
            String s = sc.nextLine().trim();
            if (s.matches("\\d+")) {
                this.length = s.length();
                this.digits = new int[length];
                for (int i = 0; i < length; i++) {
                    digits[length - 1 - i] = s.charAt(i) - '0'; // lưu ngược để dễ tính
                }
                return;
            }
            System.out.println("Invalid input! Please enter digits only.");
        }
    }
    public int[] getDigits() { return digits; }
    public int getLength() { return length; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }
}
