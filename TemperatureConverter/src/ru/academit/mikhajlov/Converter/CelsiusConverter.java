package ru.academit.mikhajlov.Converter;

public class CelsiusConverter implements Converter {
    private static final String NAME = "Цельсий";

    CelsiusConverter(Converters converters) {
        converters.add(NAME, this);
    }

    @Override
    public double toCelsius(double value) {
        return value;
    }

    @Override
    public double fromCelsius(double value) {
        return value;
    }
}
