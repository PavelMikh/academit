package ru.academit.mikhajlov.main;

import ru.academit.mikhajlov.shapes.Shape;

import java.util.Comparator;

public class ShapesPerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o1.getPerimeter(), o2.getPerimeter());
    }
}
