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
        Triangle triangle1 = new Triangle(1, 1, 3, 14, 15, 1);
        Circle circle = new Circle(2);
        Circle circle1 = new Circle(3);

        Shape[] arrayShapes = new Shape[]{square, square1, rectangle, rectangle1, triangle, triangle1, circle, circle1};

        StringBuilder sb = new StringBuilder();
        sb.append("Фигура с максимальной площадью ")
                .append(getMaxArea(arrayShapes).toString())
                .append(" высота = ")
                .append(getMaxArea(arrayShapes).getHeight())
                .append(" ширина = ")
                .append(getMaxArea(arrayShapes).getWidth())
                .append(" площадь = ")
                .append(getMaxArea(arrayShapes).getArea())
                .append(" периметр = ")
                .append(getMaxArea(arrayShapes).getPerimeter())
                .append(System.lineSeparator())
                .append("Фигура со вторым по величине периметром ")
                .append(getSecondBySizePerimeter(arrayShapes).toString())
                .append(" высота = ")
                .append(getSecondBySizePerimeter(arrayShapes).getHeight())
                .append(" ширина = ")
                .append(getSecondBySizePerimeter(arrayShapes).getWidth())
                .append(" площадь = ")
                .append(getSecondBySizePerimeter(arrayShapes).getArea())
                .append(" периметр = ")
                .append(getSecondBySizePerimeter(arrayShapes).getPerimeter());

        String searchResult = sb.toString();

        System.out.println(searchResult);
    }

    private static Shape getMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new ShapesAreaComparator());
        return shapes[shapes.length - 1];
    }

    private static Shape getSecondBySizePerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new ShapesPerimeterComparator());
        return shapes[shapes.length - 2];
    }
}
