package ru.academit.mikhajlov.matrix;

import ru.academit.mikhajlov.Vector.Vector;

public class Matrix {
    private Vector[] lines;

    public Matrix(int n, int m) {
        Vector vector = new Vector(m);
        Vector[] lines = new Vector[n];
        for (int i = 0; i < n; i++) {
            lines[i] = vector;
        }
        this.lines = lines;
    }

    public Matrix(Matrix matrix) {
        this(matrix.lines);
    }

    public Matrix(double[][] arrays) {
        Vector[] lines = new Vector[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            lines[i] = new Vector(arrays[i]);
        }
        this.lines = lines;
    }

    public Matrix(Vector[] lines) {
        Vector[] copyLines = new Vector[lines.length];
        for (int i = 0; i < lines.length; i++) {
            copyLines[i] = new Vector(lines[i]);
        }
        this.lines = copyLines;
    }

    public int getWidth() {
        return this.lines.length;
    }

    public int getHeight() {
        return this.lines[0].getSize();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < this.lines.length - 1; i++) {
            stringBuilder.append(this.lines[i].toString()).append(", ");
        }
        return stringBuilder.append(lines[lines.length - 1]).append("}").toString();
    }

    public Vector getLine(int lineIndex) {
        return this.lines[lineIndex];
    }

    public void setLine(int lineIndex, Vector line) {
        this.lines[lineIndex] = new Vector(line);
    }

    public Vector getColumn(int componentIndex) {
        Vector column = new Vector(this.getWidth());
        for (int i = 0; i < column.getSize(); i++) {
            column.setComponent(this.lines[i].getComponent(componentIndex), i);
        }
        return column;
    }

    public void transposition() {
        Matrix matrix = new Matrix(this.getHeight(), this.getWidth());
        for (int i = 0; i < this.getHeight(); i++) {
            matrix.lines[i] = this.getColumn(i);
        }
        this.lines = matrix.lines;
    }

    public void multiplicationOnScalar(double scalar) {
        for (Vector line : this.lines) {
            line.multiplicationOnScalar(scalar);
        }
    }

    public double getDeterminant() {
        int width = getWidth();
        int height = getHeight();

        if (height != width) {
            throw new IllegalArgumentException("Высота и ширина матрицы должны быть одинаковые.");
        }
        if (height == 2) {
            return (this.lines[0].getComponent(0) * this.lines[1].getComponent(1)) -
                    (this.lines[0].getComponent(1) * this.lines[1].getComponent(0));
        }
        Matrix copy = new Matrix(this);
        double determinant = 0;
        for (int i = 0; i < height; i++) {
            double[][] tmp = new double[height - 1][width - 1];
            for (int j = 1; j < width; j++) {
                int columnIndex = 0;
                for (int m = 0; m < width; m++) {
                    if (m == i) {
                        continue;
                    }
                    tmp[j - 1][columnIndex] = copy.lines[j].getComponent(m);
                    columnIndex++;
                }
            }
            determinant += copy.lines[0].getComponent(i) * Math.pow(-1, i) * new Matrix(tmp).getDeterminant();
        }
        return determinant;
    }

    public void multiplicationOnVector(Vector vector) {
        int length = vector.getSize();
        if (getWidth() != length) {
            throw new IllegalArgumentException("Ширина матрицы и размерность вектора должны быть равны.");
        }
        for (int i = 0; i < length; i++) {
            double[] vectorComponent = new double[] {Vector.getScalarProduct(getLine(i), vector)};
            Vector tmp = new Vector(vectorComponent);
            lines[i] = tmp;
        }
    }

    public void add(Matrix matrix) {
        if ((getHeight() != matrix.getHeight()) || (getWidth() != matrix.getWidth())) {
            throw new IllegalArgumentException("Размер матрмц должен быть одинаковым.");
        }
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                lines[i].setComponent(lines[i].getComponent(j) + matrix.lines[i].getComponent(j), j);
            }
        }
    }

    public void deduction(Matrix matrix) {
        if ((getHeight() != matrix.getHeight()) || (getWidth() != matrix.getWidth())) {
            throw new IllegalArgumentException("Размер матрмц должен быть одинаковым.");
        }
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                lines[i].setComponent(lines[i].getComponent(j) - matrix.lines[i].getComponent(j), j);
            }
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.add(matrix2);
        return matrix1Copy;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.deduction(matrix2);
        return matrix1Copy;
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix2.getHeight(), matrix2.getWidth());
        for (int i = 0; i < matrix2.getHeight(); i++) {
            Vector vector = matrix2.getColumn(i);
            Matrix tmp = new Matrix(matrix1);
            tmp.multiplicationOnVector(vector);
            Vector tmpVector = new Vector(tmp.getColumn(0));
            result.lines[i] = tmpVector;
        }
        result.transposition();
        return new Matrix(result);
    }
}



