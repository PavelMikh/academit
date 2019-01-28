package ru.academit.mikhaylov1.shapes;

import java.util.Comparator;

public class ShapesPerimeterComparator implements Comparator<Shapes> {
    @Override
    public int compare(Shapes o1, Shapes o2) {
        return Double.compare(o1.getPerimeter(), o2.getPerimeter());
    }
}
