package ru.academit.mikhajlov.Converter;

public class FahrenheitConverter implements Converter {
    private static final String NAME = "Фаренгейт";

    FahrenheitConverter(Converters converters) {
        converters.add(NAME, this);
    }

    @Override
    public double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    @Override
    public double fromCelsius(double value) {
        return (value * 1.8) + 32;
    }
}
