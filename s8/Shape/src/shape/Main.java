/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shape;
public class Main {
    public static void main(String[] args) {
        // Tạo mảng Shape (đa hình)
        Shape[] shapes = {
            new Circle(5),
            new Square(4),
            new Triangle(3, 6),
            new Sphere(3),
            new Cube(2),
            new Tetrahedron(4)
        };

        // Duyệt từng phần tử
        for (Shape s : shapes) {
            System.out.println("----------------------------------");
            System.out.println("Shape: " + s);

            // Kiểm tra loại hình (instanceof)
            if (s instanceof TwoDimensionalShape) {
                System.out.printf("Area: %.2f\n", s.getArea());
            } else if (s instanceof ThreeDimensionalShape) {
                ThreeDimensionalShape t = (ThreeDimensionalShape) s;
                System.out.printf("Area: %.2f\n", t.getArea());
                System.out.printf("Volume: %.2f\n", t.getVolume());
            }
        }
    }
}
