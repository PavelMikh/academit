package ru.academit.mikhaylov1.main;

import ru.academit.mikhaylov1.shapes.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Square square = new Square(6);
        Square square1 = new Square(4);
        Rectangle rectangle = new Rectangle(2, 3);
        Rectangle rectangle1 = new Rectangle(3, 4);
        Triangle triangle = new Triangle(1, 1, 2, 5, 3, 1);
        Triangle triangle1 = new Triangle(1, 1, 3, 7, 5, 1);
        Circle circle = new Circle(2);
        Circle circle1 = new Circle(3);

        Shapes[] arrayShapes = new Shapes[]{square, square1, rectangle, rectangle1, triangle, triangle1, circle, circle1};

        StringBuilder sb = new StringBuilder();
        sb.append("Фигура с максимальной площадью ")
                .append(maxArea(arrayShapes).toString())
                .append(" высота = ")
                .append(maxArea(arrayShapes).getHeight())
                .append(" ширина = ")
                .append(maxArea(arrayShapes).getWidth())
                .append(" площадь = ")
                .append(maxArea(arrayShapes).getArea())
                .append(" периметр = ")
                .append(maxArea(arrayShapes).getPerimeter())
                .append(System.lineSeparator())
                .append("Фигура со вторым по величине периметром ")
                .append(secondMaxPerimeter(arrayShapes).toString())
                .append(" высота = ")
                .append(secondMaxPerimeter(arrayShapes).getHeight())
                .append(" ширина = ")
                .append(secondMaxPerimeter(arrayShapes).getWidth())
                .append(" площадь = ")
                .append(secondMaxPerimeter(arrayShapes).getArea())
                .append(" периметр = ")
                .append(secondMaxPerimeter(arrayShapes).getPerimeter());

        String searchResult = sb.toString();

        System.out.println(searchResult);
    }

    private static Shapes maxArea(Shapes[] shapes) {
        Arrays.sort(shapes, new ShapesAreaComparator());
        return shapes[shapes.length - 1];
    }

    private static Shapes secondMaxPerimeter(Shapes[] shapes) {
        Arrays.sort(shapes, new ShapesPerimeterComparator());
        return shapes[shapes.length - 2];
    }
}
