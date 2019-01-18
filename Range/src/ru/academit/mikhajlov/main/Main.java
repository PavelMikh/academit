package ru.academit.mikhajlov.main;

import ru.academit.mikhajlov.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double from;
        double to;
        double from1;
        double to1;
        do {
            System.out.println("Вводите последовательно начальные и конечные значения диапазонов. Начальное значение должно быть меньше либо равно конечному.");
            System.out.println("Введите начальное значение первого диапазона: ");
            from = scanner.nextDouble();
            System.out.println("Введите конечное значение первого диапазона: ");
            to = scanner.nextDouble();
            System.out.println("Введите начальное значение второго диапазона:");
            from1 = scanner.nextDouble();
            System.out.println("Введите конечное значение второго диапазона:");
            to1 = scanner.nextDouble();
        } while (from > to || from1 > to1);

        Range range = new Range(from, to);
        Range range1 = new Range(from1, to1);

        Range intersectionResult = range.getIntersection(range1);
        if (intersectionResult == null) {
            System.out.println((Range) null);
        } else {
            System.out.printf("Начальное значение диапазона - пересечения = %.2f%nКонечное значение диапазона - пересечения = %.2f%n", intersectionResult.getFrom(), intersectionResult.getTo());
            System.out.println("Длина полученного диапазона = " + intersectionResult.getLength());
        }

        Range[] unionResult = range.getUnion(range1);
        if (unionResult.length == 1) {
            System.out.printf("Результатом объединения двух диапазонов являются диапазон с начальным значением = %.2f и конечным значением = %.2f%n", unionResult[0].getFrom(), unionResult[0].getTo());
            System.out.println("Длина полученного диапазона = " + unionResult[0].getLength());
        }
        if (unionResult.length == 2) {
            System.out.printf("Результатом объединения двух диапазонов являются диапазон 1 с начальным значением = %.2f и конечным значением =  %.2f%n и диапазон 2 с начальным значением = %.2f и конечным значением = %.2f.%n", unionResult[0].getFrom(), unionResult[0].getTo(), unionResult[1].getFrom(), unionResult[1].getTo());
            System.out.println("Длина полученного диапазона = " + (unionResult[0].getLength() + unionResult[1].getLength()));
        }

        Range[] differenceResult = range.getDifference(range1);
        if (differenceResult.length == 0) {
            System.out.println("Результат разности двух диапазонов - пустой диапазон.");
        } else if (differenceResult.length == 1) {
            System.out.printf("Результатом разности двух диапазонов являются диапазон с начальным значением = %.2f и конечным значением = %.2f%n", differenceResult[0].getFrom(), differenceResult[0].getTo());
            System.out.println("Длина полученного диапазона = " + differenceResult[0].getLength());
        } else if (differenceResult.length == 2) {
            System.out.printf("Результатом разности двух диапазонов являются диапазон 1 с начальным значением = %.2f и конечным значением =  %.2f%n и диапазон 2 с начальным значением = %.2f и конечным значением = %.2f.%n", differenceResult[0].getFrom(), differenceResult[0].getTo(), differenceResult[1].getFrom(), differenceResult[1].getTo());
            System.out.println("Длина полученного диапазона = " + (differenceResult[0].getLength() + differenceResult[1].getLength()));
        }
    }
}
