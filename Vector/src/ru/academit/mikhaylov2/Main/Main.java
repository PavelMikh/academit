package ru.academit.mikhaylov2.Main;

import ru.academit.mikhaylov2.Vector.Vector;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] doubles = new double[]{1, 2, 3};

        System.out.println("Введите размерность вектора: ");

        Vector vector = new Vector(scanner.nextInt());

        vector.setVectorComponents(doubles);
        Vector vector1 = new Vector(vector);
        vector.setVectorComponents(new double[]{4, 8, 6});


        String b = Arrays.toString(vector1.getVectorComponents());

        String a = Arrays.toString(vector.getVectorComponents());

        System.out.println(vector.equals(vector1));
        System.out.println(vector.getN() + ", " + vector1.getN() + ", " + a + ", " + b);
    }
}
