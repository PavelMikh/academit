package ru.academit.mikhajlov.matrix;

import ru.academit.mikhajlov.Vector.Vector;

public class Matrix {
    private double[][] matrix;
    private int n;
    private int m;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        for (int i = 0; i <= n; i++) {
            Vector vector = new Vector(m);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (j == 0) {
                    stringBuilder.append("{");
                }
                stringBuilder.append(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("}")
                    .append(", ");
        }
        return stringBuilder.append(matrix[matrix.length - 1]).append("}").toString();
    }
}
