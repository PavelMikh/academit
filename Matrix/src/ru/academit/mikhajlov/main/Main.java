package ru.academit.mikhajlov.main;

import ru.academit.mikhajlov.Vector.Vector;
import ru.academit.mikhajlov.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 3);


        double[][] arrays = new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Vector[] lines = new Vector[]{new Vector(new double[]{3, -3, 5, 5}), new Vector(new double[]{2, -3, 2, 3}),
                new Vector(new double[]{4, -7, 3, 4}), new Vector(new double[]{5, -5, 3, 8})};
        Vector[] lines1 = new Vector[]{new Vector(new double[]{1, 2, 3}), new Vector(new double[]{4, 5, 6})};

        Matrix matrix2 = new Matrix(lines1);
        Matrix matrix3 = new Matrix(lines);


        System.out.println(matrix3.getLine(1).toString());
        System.out.println(matrix3.getColumn(1).toString());
        System.out.println(matrix3.getDeterminant());
//        System.out.println(matrix2.toString());
//        System.out.println(matrix3.toString());
    }
}
