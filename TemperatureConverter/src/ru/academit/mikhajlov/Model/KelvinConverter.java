package ru.academit.mikhajlov.Model;

public class KelvinConverter implements Converter {
    private static final String NAME = "Кельвин";

    KelvinConverter(Converters converters) {
        converters.add(NAME, this);
    }

    @Override
    public double toCelsius(double value) {
        return value - 273.15;
    }

    @Override
    public double fromCelsius(double value) {
        return value + 273.15;
    }
}
