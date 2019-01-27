package ru.academit.mikhaylov1.main;

import ru.academit.mikhaylov1.shapes.*;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(5);
        Square square1 = new Square(4);
        Rectangle rectangle = new Rectangle(2, 3);
        Rectangle rectangle1 = new Rectangle(3, 4);
        Triangle triangle = new Triangle(1, 1, 2, 5, 3, 1);
        Triangle triangle1 = new Triangle(1, 1, 3, 7, 5, 1);
        Circle circle = new Circle(2);
        Circle circle1 = new Circle(3);
    }

    public Shapes maxArea(Shapes... shapes) {
        return null;
    }
}
