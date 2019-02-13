package ru.academit.mikhajlov.main;

import ru.academit.mikhajlov.Vector.Vector;
import ru.academit.mikhajlov.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 3);


        double[][] arrays = new double[][]{{5, 8, -4}, {6, 9, -5}, {4, 7, -3}};
        double[][] arrays1 = new double[][]{{3, 2, 5}, {4, -1, 3}, {9, 6, 5}};


        Vector[] lines = new Vector[]{new Vector(new double[]{3, -3, 5, 5}), new Vector(new double[]{2, -3, 2, 3}),
                new Vector(new double[]{4, -7, 3, 4}), new Vector(new double[]{5, -5, 3, 8})};
        Vector[] lines1 = new Vector[]{new Vector(new double[]{1, 2, 3}), new Vector(new double[]{4, 5, 6})};

        double[] numbers = new double[]{2, -3, 1};
        Vector vector = new Vector(numbers);

        Matrix matrix2 = new Matrix(arrays);
        matrix2.multiplicationOnVector(vector);

        Matrix matrix3 = new Matrix(lines);
        matrix3.transposition();

        Matrix matrix4 = new Matrix(arrays);
        Matrix matrix5 = new Matrix(arrays);
        matrix4.add(matrix5);

        Matrix matrix6 = new Matrix(arrays);
        Matrix matrix7 = new Matrix(arrays1);
        Matrix matrix8 = Matrix.multiplication(matrix6, matrix7);

        System.out.println(matrix3.getLine(1).toString());
        System.out.println(matrix3.getColumn(1).toString());
        System.out.println(matrix3.getDeterminant());
        System.out.println(matrix2.toString());
        System.out.println(matrix4.toString());
        System.out.println(matrix8.toString());
    }
}
