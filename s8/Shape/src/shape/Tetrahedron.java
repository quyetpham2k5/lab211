/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shape;

public class Tetrahedron extends ThreeDimensionalShape {
    private double edge;

    public Tetrahedron(double edge) {
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * edge * edge; // A = √3 * a²
    }

    @Override
    public double getVolume() {
        return (1.0 / 12.0) * Math.sqrt(2) * Math.pow(edge, 3); // V = (1/12)*√2*a³
    }

    @Override
    public String toString() {
        return String.format("Tetrahedron (edge=%.2f)", edge);
    }
}
