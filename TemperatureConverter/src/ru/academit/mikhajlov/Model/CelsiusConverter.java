package ru.academit.mikhajlov.Model;

public class CelsiusConverter implements Converter {
    static final String NAME = "Цельсий";

    @Override
    public double toCelsius(double value) {
        return value;
    }

    @Override
    public double fromCelsius(double value) {
        return value;
    }
}
