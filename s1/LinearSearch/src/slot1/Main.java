/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1;



import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of array: ");
        int n = readPositiveInt(sc);
        
        LinearSearch ls = new LinearSearch(n);
        ls.fillRandom();

        System.out.print("Enter search value: ");
        int key = sc.nextInt();

        System.out.println("The array: " + ls.showArray());

        int idx = ls.findIndex(key);
        if (idx != -1) {
            System.out.println("Found " + key + " at index: " + idx);
        } else {
            System.out.println(key + " is not found in array.");
        }

        
    }

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
