package ru.academit.mikhajlov.Converter;

public class KelvinConverter implements Converter {
    public double toCelsius(double value) {
        return value - 273.15;
    }

    public double fromCelsius(double value) {
        return value + 273.15;
    }
}
