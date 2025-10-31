/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shape;

public class Cube extends ThreeDimensionalShape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return 6 * side * side; // 6a²
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3); // a³
    }

    @Override
    public String toString() {
        return String.format("Cube (side=%.2f)", side);
    }
}
