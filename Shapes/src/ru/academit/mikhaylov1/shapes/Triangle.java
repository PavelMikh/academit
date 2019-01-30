package ru.academit.mikhaylov1.shapes;

public class Triangle implements Shape {
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

    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static double getMax(double a1, double a2, double a3) {
        if (a1 > Math.max(a2, a3)) {
            return a1;
        } else {
            return Math.max(a2, a3);
        }
    }

    private static double getMin(double a1, double a2, double a3) {
        if (a1 < Math.min(a2, a3)) {
            return a1;
        } else {
            return Math.min(a2, a3);
        }
    }

    @Override
    public double getWidth() {
        return getMax(x1, x2, x3) - getMin(x1, x2, x3);
    }

    @Override
    public double getHeight() {
        return getMax(y1, y2, y3) - getMin(y1, y2, y3);
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
        return "[Треугольник : координаты первой вершины x1 = " + x1 + " y1 = " + y1 + "; "
                + "координаты вторвой вершины x2 = " + x2 + " y2 = " + y2 + "; "
                + "координаты третьей вершины x3 = " + x3 + " y3 = " + y3 + "]";
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
        return x1 == triangle.x1 && y1 == triangle.y1 && x2 == triangle.x2 &&
                y2 == triangle.y2 && x3 == triangle.x3 && y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 11;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);

        return hash;
    }
}
