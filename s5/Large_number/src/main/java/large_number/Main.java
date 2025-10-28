/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package large_number;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LargeNumber num1 = new LargeNumber();
        LargeNumber num2 = new LargeNumber();
        LargeNumberCalculator calc = new LargeNumberCalculator();

        System.out.println("=== Large Number Calculator ===");
        num1.input(sc, "first number");
        num2.input(sc, "second number");

        LargeNumber sum = calc.add(num1, num2);
        LargeNumber product = calc.multiply(num1, num2);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        sc.close();
    }
}

