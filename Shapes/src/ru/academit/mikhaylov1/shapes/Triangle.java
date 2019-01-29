package ru.academit.mikhaylov1.shapes;

public class Triangle implements Shapes {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public double getWidth() {
        double max;
        double min;
        if (x1 > Math.max(x2, x3)) {
            max = x1;
        } else {
            max = Math.max(x2, x3);
        }

        if (x1 < Math.min(x2, x3)) {
            min = x1;
        } else {
            min = Math.min(x2, x3);
        }
        return max - min;
    }

    @Override
    public double getHeight() {
        double max;
        double min;
        if (y1 > Math.max(y2, y3)) {
            max = y1;
        } else {
            max = Math.max(y2, y3);
        }

        if (y1 < Math.min(y2, y3)) {
            min = y1;
        } else {
            min = Math.min(y2, y3);
        }
        return max - min;
    }

    @Override
    public double getArea() {
        double aLength = getDistance(x1, y1, x2, y2);
        double bLength = getDistance(x1, y1, x3, y3);
        double cLength = getDistance(x2, y2, x3, y3);
        double semiPerimeter = (aLength + bLength + cLength) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - aLength) * (semiPerimeter - bLength) * (semiPerimeter - cLength));
    }

    @Override
    public double getPerimeter() {
        double aLength = getDistance(x1, y1, x2, y2);
        double bLength = getDistance(x1, y1, x3, y3);
        double cLength = getDistance(x2, y2, x3, y3);
        return aLength + bLength + cLength;
    }

    @Override
    public String toString() {
        return "[Треугольник : координаты первой вершины x1 = " + x1 + " y1 = " + y1 + "; " + "координаты вторвой вершины x2 = " + x2 + " y2 = " + y2 + "; " + "координаты третьей вершины x3 = " + x3 + " y3 = " + y3 + "]" + System.lineSeparator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return triangle.x1 == ((Triangle) o).x1 && triangle.x2 == ((Triangle) o).x2 && triangle.x3 == ((Triangle) o).x3 && triangle.y1 == ((Triangle) o).y1 && triangle.y2 == ((Triangle) o).y2 && triangle.y3 == ((Triangle) o).y3;
    }
}
