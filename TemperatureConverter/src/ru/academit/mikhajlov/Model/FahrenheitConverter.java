package ru.academit.mikhajlov.Model;

public class FahrenheitConverter implements Converter {
    FahrenheitConverter(Converters converters) {
        String NAME = "Фаренгейт";
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
