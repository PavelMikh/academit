package ru.academit.mikhajlov.Model;

public class FahrenheitConverter implements Converter {
    static final String NAME = "Фаренгейт";

    @Override
    public double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    @Override
    public double fromCelsius(double value) {
        return (value * 1.8) + 32;
    }
}
