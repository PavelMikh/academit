package ru.academit.mikhaylov1.shapes;

import java.util.Comparator;

public class ShapesAreaComparator implements Comparator<Shapes> {

    @Override
    public int compare(Shapes o1, Shapes o2) {
        return Double.compare(o1.getArea(), o2.getArea());
    }
}
