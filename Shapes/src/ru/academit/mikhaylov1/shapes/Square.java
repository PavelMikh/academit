package ru.academit.mikhaylov1.shapes;

public class Square implements Shapes {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return "[Квадрат : длина стороны = " + sideLength + "]" + System.lineSeparator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return square.sideLength == ((Square) o).sideLength;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(sideLength);
    }
}