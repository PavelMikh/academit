import java.util.Scanner;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public Range getIntersection(Range range) {
        double from = this.from;
        double to = this.to;
        double from1 = range.from;
        double to1 = range.to;

        if (from1 > to || from > to1) {
            return null;
        }
        if (from1 >= from && to1 >= to) {
            return new Range(from1, to);
        }
        if (from >= from1 && to >= to1) {
            return new Range(from, to1);
        }
        if (from1 >= from && to >= to1) {
            return new Range(from1, to1);
        } else {
            return new Range(from, to);
        }
    }

    public Range[] getUnion(Range range) {
        double from = this.from;
        double to = this.to;
        double from1 = range.from;
        double to1 = range.to;

        if (from1 > to || from > to1) {
            return new Range[]{new Range(from, to), new Range(from1, to1)};
        }
        if (from1 >= from && to1 >= to) {
            return new Range[]{new Range(from, to1)};
        }
        if (from >= from1 && to >= to1) {
            return new Range[]{new Range(from1, to)};
        }
        if (from1 >= from && to >= to1) {
            return new Range[]{new Range(from, to)};
        } else {
            return new Range[]{new Range(from1, to1)};
        }
    }

    public Range[] getDifference(Range range) {
        double from = this.from;
        double to = this.to;
        double from1 = range.from;
        double to1 = range.to;

        if (from >= from1 && to >= to1 && from <= to1) {
            return new Range[]{new Range(to1, to)};
        }
        if (from1 > from && to > to1) {
            return new Range[]{new Range(from, from1), new Range(to1, to)};
        }
        if (from1 > to || from > to1) {
            return new Range[]{new Range(from, to)};
        }
        if (from1 >= from && to1 >= to) {
            return new Range[]{new Range(from, from1)};
        } else {
            return new Range[]{null};
        }
    }

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
            System.out.printf("Начальное значение диапазона - пересечения = %.2f%nКонечное значение диапазона - пересечения = %.2f%n", intersectionResult.from, intersectionResult.to);
            System.out.println("Длина полученного диапазона = " + intersectionResult.getLength());
        }

        Range[] unionResult = range.getUnion(range1);
        if (unionResult.length == 1) {
            System.out.printf("Результатом объединения двух диапазонов являются диапазон с начальным значением = %.2f и конечным значением = %.2f%n", unionResult[0].from, unionResult[0].to);
            System.out.println("Длина полученного диапазона = " + unionResult[0].getLength());
        }
        if (unionResult.length == 2) {
            System.out.printf("Результатом объединения двух диапазонов являются диапазон 1 с начальным значением = %.2f и конечным значением =  %.2f%n и диапазон 2 с начальным значением = %.2f и конечным значением = %.2f.%n", unionResult[0].from, unionResult[0].to, unionResult[1].from, unionResult[1].to);
            System.out.println("Длина полученного диапазона = " + (unionResult[0].getLength() + unionResult[1].getLength()));
        }

        Range[] differenceResult = range.getDifference(range1);
        if (differenceResult.length == 1) {
            if (differenceResult[0] == null) {
                System.out.println("Результат разности двух диапазонов - пустой диапазон.");
            } else {
                System.out.printf("Результатом разности двух диапазонов являются диапазон с начальным значением = %.2f и конечным значением = %.2f%n", differenceResult[0].from, differenceResult[0].to);
                System.out.println("Длина полученного диапазона = " + differenceResult[0].getLength());
            }
        }
        if (differenceResult.length == 2) {
            System.out.printf("Результатом разности двух диапазонов являются диапазон 1 с начальным значением = %.2f и конечным значением =  %.2f%n и диапазон 2 с начальным значением = %.2f и конечным значением = %.2f.%n", differenceResult[0].from, differenceResult[0].to, differenceResult[1].from, differenceResult[1].to);
            System.out.println("Длина полученного диапазона = " + (differenceResult[0].getLength() + differenceResult[1].getLength()));
        }
    }
}