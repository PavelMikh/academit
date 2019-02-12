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
        if (this.getHeight() != this.getWidth()) {
            throw new IllegalArgumentException("Высота и ширина матрицы должны быть одинаковые.");
        }
        if (this.getHeight() == 2 && this.getWidth() == 2) {
            return (this.lines[0].getComponent(0) * this.lines[1].getComponent(1)) -
                    (this.lines[0].getComponent(1) * this.lines[1].getComponent(0));
        }

        Matrix copy = new Matrix(this);
        double determinant = 0;
        for (int i = 0; i < this.getHeight(); i++) {
            double[][] tmp = new double[this.getHeight() - 1][this.getWidth() - 1];
            for (int j = 1; j < this.getWidth(); j++) {
                int columnIndex = 0;
                for (int m = 0; m < this.getWidth(); m++) {
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

    public void multiplicationOnVector (Vector vector) {
        if (this.getWidth() != vector.getSize()) {
            throw new IllegalArgumentException("Ширина матрицы и размерность вектора должны быть равны.");
        }
        Vector[] array = new Vector[] {vector};
        Matrix matrix = new Matrix(array);
        matrix.transposition();
        Matrix matrixT = new Matrix(matrix);
        Matrix productResult = new Matrix(vector.getSize(), 1);
        for (int i = 0; i < getHeight(); i++) {
            double componentsSum = 0;
            for (int j = 0; j < getWidth(); j++) {
                componentsSum += this.lines[i].getComponent(j) * matrixT.lines[j].getComponent(0);
            }
            productResult.lines[i].setComponent(componentsSum, 0);
        }
        this.lines = productResult.lines;
    }
}



