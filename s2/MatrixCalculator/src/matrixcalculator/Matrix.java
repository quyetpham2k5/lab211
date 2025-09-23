/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrixcalculator;


public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Row and column must be positive.");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public Matrix(double[][] source) {
        if (source == null || source.length == 0 || source[0].length == 0) {
            throw new IllegalArgumentException("Source array must be non-empty.");
        }
        this.rows = source.length;
        this.cols = source[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (source[i].length != cols) {
                throw new IllegalArgumentException("All rows must have the same length.");
            }
            System.arraycopy(source[i], 0, this.data[i], 0, cols);
        }
    }

    // Getters & Setters (theo nguyên tắc có getter/setter):contentReference[oaicite:7]{index=7}
    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public double[][] getData() { return data; }

    public void setValue(int r, int c, double value) {
        checkIndex(r, c);
        data[r][c] = value;
    }

    public double getValue(int r, int c) {
        checkIndex(r, c);
        return data[r][c];
    }

    private void checkIndex(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }

    // Function 1: Addition matrices (đúng chữ ký & tên hàm theo đề):contentReference[oaicite:8]{index=8}
    public Matrix additionMatrix(Matrix matrix2) {
        if (matrix2 == null) throw new IllegalArgumentException("Second matrix must not be null.");
        if (this.rows != matrix2.rows || this.cols != matrix2.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimension for addition.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + matrix2.data[i][j];
            }
        }
        return result;
    }

    // Function 2: Subtraction matrices:contentReference[oaicite:9]{index=9}
    public Matrix subtractionMatrix(Matrix matrix2) {
        if (matrix2 == null) throw new IllegalArgumentException("Second matrix must not be null.");
        if (this.rows != matrix2.rows || this.cols != matrix2.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimension for subtraction.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - matrix2.data[i][j];
            }
        }
        return result;
    }

    // Function 3: Multiplication matrices:contentReference[oaicite:10]{index=10}
    public Matrix multiplicationMatrix(Matrix matrix2) {
        if (matrix2 == null) throw new IllegalArgumentException("Second matrix must not be null.");
        if (this.cols != matrix2.rows) {
            throw new IllegalArgumentException("Number of columns of A must equal number of rows of B.");
        }
        Matrix result = new Matrix(this.rows, matrix2.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix2.cols; j++) {
                double sum = 0.0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * matrix2.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }
}
