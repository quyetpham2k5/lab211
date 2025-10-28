/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package largenumber_slot5;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        String num1 = sc.nextLine().trim();

        System.out.print("Enter second number: ");
        String num2 = sc.nextLine().trim();

        System.out.println("\n=== Result ===");
        System.out.println("Sum: " + LargeNumber.add(num1, num2));
        System.out.println("Product: " + LargeNumber.multiply(num1, num2));

        sc.close();
    }
}
