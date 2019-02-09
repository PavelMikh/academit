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
        /*Vector[] lines = new Vector[matrix.lines.length];
        for (int i = 0; i < matrix.lines.length; i++) {
            lines[i] = new Vector(matrix.lines[i]);
        }
        this.lines = lines;*/
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
//        this.lines = lines;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < this.lines.length - 1; i++) {
            stringBuilder.append(this.lines[i].toString()).append(", ");
        }
        return stringBuilder.append(lines[lines.length - 1]).append("}").toString();
    }

    public int[] getSize() {
        return new int[]{this.lines.length, this.lines[0].getSize()};
    }

    public Vector getLine(int lineIndex) {
        return this.lines[lineIndex];
    }

    public void setLine(int lineIndex, Vector line) {
        this.lines[lineIndex] = new Vector(line);
    }

    public Vector getColumn(int componentIndex) {
        Vector column = new Vector(this.lines.length);
        for (int i = 0; i < column.getSize(); i++) {
            column.setComponent(this.lines[i].getComponent(componentIndex), i);
        }
        return column;
    }

    public void transposition() {
        Matrix matrix = new Matrix(this.getSize()[1], this.getSize()[0]);
        for (int i = 0; i < this.getSize()[1]; i++) {
            matrix.lines[i] = this.getColumn(i);
        }
        this.lines = matrix.lines;
    }

    public void multiplicationOnScalar(double scalar) {
        for (Vector line : this.lines) {
            line.multiplicationOnScalar(scalar);
        }
    }
}


