package ru.academit.mikhajlov.main;

import ru.academit.mikhajlov.Vector.Vector;
import ru.academit.mikhajlov.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
//        Проверка конструкторов
        Matrix matrix1 = new Matrix(2, 3);
        System.out.println("Матрица 1 " + matrix1);//Матрица1 нулей размера (3 * 3).

        double[][] arrays1 = new double[][]{{5, 8, -4}, {6, 9, -5}, {4, 7, -3}}; // Массив1 для заполнения матрицы2
        Matrix matrix2 = new Matrix(arrays1);
        System.out.println("Матрица 2 " + matrix2);

        Vector[] lines1 = new Vector[]{new Vector(new double[]{3, 2, 5}), new Vector(new double[]{4, -1, 3}),
                new Vector(new double[]{9, 6, 5})}; // Массив векторов1 для заполнения матрицы3
        Matrix matrix3 = new Matrix(lines1);
        System.out.println("Матрица 3 " + matrix3);

        Matrix matrix4 = new Matrix(matrix2); //Матрица4 - копия матрицы2
        System.out.println("Матрица 4 " + matrix4);

//        Проверка нестатических методов
        System.out.printf("Высота матрицы 2 = %d, ширина матрицы 2 = %d", matrix2.getRowsCount(), matrix2.getColumnsCount());
        System.out.println();
        double[] array = new double[]{2, -3, 1};
        Vector vector1 = new Vector(array); // Вектор1 строка

        matrix1.setRow(1, vector1); // Замена строки с индексом 1 вектора 1 на вектор1
        System.out.println("Измененная строка с индексом 2 матрицы 1 " + matrix1.getRow(1));

        System.out.println("Столбец с индексом 1 матрицы 1 " + matrix1.getColumn(1));

        matrix1.transposition();
        System.out.println("Транспонированная матрица 1 " + matrix1);

        matrix1.multiplicationOnScalar(2);
        System.out.println("Матрица 1 умноженая на 2 " + matrix1);

        System.out.println("Определитель матрицы 3 = " + matrix3.getDeterminant());

        System.out.println("Результат умножения матрицы 4 на вектор 1 " + matrix4.getMultiplicationOnVector(vector1));

        matrix2.add(matrix3);
        System.out.println("Результат сложения матрицы 2 и матрицы 3 " + matrix2);

        matrix2.deduction(matrix3);
        System.out.println("Результат вычитания из матрицы 2 матрицы 3 " + matrix2);

//        Проверка статических методов
        Matrix matrix5 = Matrix.getSum(matrix2, matrix3);
        System.out.println("Матрица 5 равна результату сложения матрицы 2 и матрицы 3 " + matrix5);

        Matrix matrix6 = Matrix.getDifference(matrix2, matrix3);
        System.out.println("Матрица 6 равна результату вычитания из матрицы 2 матрицы 3 " + matrix6);

        Matrix matrix7 = Matrix.getMultiplication(matrix2, matrix3);
        System.out.println("Матрица 7 равна результату умножения матрицы 2 на матрицу 3 " + matrix7);
    }
}
