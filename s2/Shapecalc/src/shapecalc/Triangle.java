/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapecalc;



public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() { }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

  
    public double getSideA() { return sideA; }
    public void setSideA(double sideA) { this.sideA = sideA; }

    public double getSideB() { return sideB; }
    public void setSideB(double sideB) { this.sideB = sideB; }

    public double getSideC() { return sideC; }
    public void setSideC(double sideC) { this.sideC = sideC; }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);
        // Bạn có thể format 2 chữ số thập phân nếu muốn khớp ví dụ:
        // System.out.println("Area:" + String.format("%.2f", getArea()));
        System.out.println("Area:" + getArea());
        System.out.println("Perimeter:" + getPerimeter());
    }

    
    public static boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
