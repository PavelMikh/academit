package ru.academit.mikhajlov.Converter;

public class FahrenheitConverter implements Converter {
    public double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    public double fromCelsius(double value) {
        return (value * 1.8) + 32;
    }
}
