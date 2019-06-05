package ru.academit.mikhajlov.Model;

public class KelvinConverter implements Converter {

    KelvinConverter(Converters converters) {
        String NAME = "Кельвин";
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
