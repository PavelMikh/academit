package ru.academit.mikhajlov.Model;

public class KelvinConverter implements Converter {
    static final String NAME = "Кельвин";

    @Override
    public double toCelsius(double value) {
        return value - 273.15;
    }

    @Override
    public double fromCelsius(double value) {
        return value + 273.15;
    }
}
