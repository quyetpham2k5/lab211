/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapecalc;



import java.util.Scanner;


public class Menu {
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("=====Calculator Shape Program=====");

    
        double rectWidth  = readPositiveDouble("Please input side width of Rectangle: ");
        double rectLength = readPositiveDouble("Please input length of Rectangle: ");

        
        double radius = readPositiveDouble("Please input radius of Circle: ");

        
        double sideA = readPositiveDouble("Please input side A of Triangle: ");
        double sideB = readPositiveDouble("Please input side B of Triangle: ");
        double sideC = readPositiveDouble("Please input side C of Triangle: ");

        
        if (!Triangle.isValidTriangle(sideA, sideB, sideC)) {
            System.out.println("Invalid triangle sides (violates triangle inequality). Program exits.");
            return;
        }

        
        Rectangle rectangle = new Rectangle(rectWidth, rectLength);
        Circle circle = new Circle(radius);
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        rectangle.printResult();
        circle.printResult();
        triangle.printResult();

        
    }

    private double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = sc.nextLine().trim();
            try {
                double val = Double.parseDouble(raw);
                if (val > 0) return val;
                System.out.println("Value must be a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Value must be a number.");
            }
        }
    }
}
