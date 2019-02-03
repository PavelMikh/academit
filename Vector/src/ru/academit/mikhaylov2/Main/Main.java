package ru.academit.mikhaylov2.Main;

import ru.academit.mikhaylov2.Vector.Vector;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] doubles = new double[]{1, 2, 3};

        double[] doubles1 = new double[]{1, 2, 3, 4};

//        System.out.println("Введите размерность вектора: ");

        int n = doubles.length;//scanner.nextInt();

        Vector vector = new Vector(n, doubles);

        Vector vector1 = new Vector(vector);
        Vector vector2 = new Vector(doubles1.length, doubles);
        Vector vector3 = vector.getSum(vector2);
        vector2.getMultiplicationOfVectorOnScalar(3);

        String a = Arrays.toString(vector.getComponents());

        String b = Arrays.toString(vector1.getComponents());

        String d = Arrays.toString(vector2.getComponents());



        System.out.printf("%s, %s, %s; ", a, b, d);
    }
}
