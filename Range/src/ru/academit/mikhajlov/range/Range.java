package ru.academit.mikhajlov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    private boolean isInside(double number) {
        return (number >= from) && (number <= to);
    }

    public Range getIntersection(Range range) {
        if (isInside(range.to) && (from <= range.from)) {
            return new Range(range.from, range.to);
        } else if ((range.isInside(to) && (from >= range.from))) {
            return new Range(from, to);
        } else {
            return null;
        }
    }

    public Range[] getUnion(Range range) {
        if (Math.max(from, range.from) < Math.min(to, range.to)) {
            // if (isInside(range.from) && isInside(range.to))
            if (to > range.to && range.from > from) {
                return new Range[]{new Range(from, to)};
            } else if (to < range.to && range.from < from) {
                return new Range[]{new Range(range.from, range.to)};
            }
            return new Range[]{new Range(Math.max(from, range.from), Math.min(to, range.to))};
        } else {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }
    }

    public Range[] getDifference(Range range) {
        double from = this.from;
        double to = this.to;
        double from1 = range.from;
        double to1 = range.to;

        if (from1 > to || from > to1) { // Пересечения нет
            return new Range[]{new Range(from, to)};
        } else if (from >= from1 && to >= to1 /*&& from <= to1*/) { // пересечение по одному концу
            return new Range[]{new Range(from, to)};
        }
        if (from1 >= from && to1 >= to) { // Пересечение по одному концу
            return new Range[]{new Range(from, to)};
        }
        if (from1 > from && to > to1) {
            return new Range[]{new Range(from, from1), new Range(to1, to)};
        } else { // Пустое множество
            return new Range[]{};
        }
    }
}