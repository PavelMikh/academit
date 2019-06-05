package ru.academit.mikhajlov.Model;

public class CelsiusConverter implements Converter {

    CelsiusConverter(Converters converters) {
        String NAME = "Цельсий";
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
