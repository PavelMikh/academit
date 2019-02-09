package ru.academit.mikhajlov.main;

import ru.academit.mikhajlov.Vector.Vector;
import ru.academit.mikhajlov.matrix.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 3);


        double[][] arrays = new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Vector[] lines = new Vector[]{new Vector(new double[]{1, 2, 3}), new Vector(new double[]{4, 5, 6}),
                new Vector(new double[]{7, 8, 9})};
        Vector[] lines1 = new Vector[]{new Vector(new double[]{1, 2, 3}), new Vector(new double[]{4, 5, 6})};

        Matrix matrix2 = new Matrix(lines1);
        Matrix matrix3 = new Matrix(lines);

        System.out.println(Arrays.toString(matrix3.getSize()));

        System.out.println(matrix3.getLine(1).toString());
        System.out.println(matrix3.getColumn(1).toString());
        matrix2.transposition();
        matrix3.multiplicationOnScalar(2);
        System.out.println(matrix2.toString());
        System.out.println(matrix3.toString());
    }
}
