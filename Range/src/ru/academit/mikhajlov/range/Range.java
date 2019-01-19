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

    public boolean isInside(double number) {
        return (number >= from) && (number <= to);
    }

    public Range getIntersection(Range range) {
        double from = Math.max(this.from, range.from);
        double to = Math.min(this.to, range.to);
        if (from >= to) {
            return null;
        } else {
            return new Range(from, to);
        }
    }

    public Range[] getUnion(Range range) {
        if (Math.max(from, range.from) > Math.min(to, range.to)) {
            return new Range[]{new Range(Math.min(from, range.from), Math.min(to, range.to)), new Range(Math.max(from, range.from), Math.max(to, range.to))};
        } else {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }
    }

    public Range[] getDifference(Range range) {
        if (range.from > to || from > range.to) {
            return new Range[]{new Range(from, to)};
        } else if (from >= range.from && to > range.to) {
            return new Range[]{new Range(range.to, to)};
        } else if (range.from >= from && range.to > to) {
            return new Range[]{new Range(from, range.from)};
        } else if (range.from > from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        } else {
            return new Range[]{};
        }
    }
}