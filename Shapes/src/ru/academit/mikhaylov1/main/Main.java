package ru.academit.mikhaylov1.main;

import ru.academit.mikhaylov1.shapes.*;

import java.util.Arrays;

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

        Shapes[] shapes = new Shapes[]{square, square1, rectangle, rectangle1, triangle, triangle1, circle, circle1};

        Arrays.sort(shapes, new ShapesAreaComparator());

        System.out.println(Arrays.toString(shapes));
    }
}
