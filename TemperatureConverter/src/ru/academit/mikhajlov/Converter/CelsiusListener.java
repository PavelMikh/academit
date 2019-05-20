package ru.academit.mikhajlov.Converter;

public class CelsiusListener extends TemperatureAction {
    public CelsiusListener(Temperatures temperatures) {
        super(temperatures);
        putValue(NAME, "Цельсий");
    }

    @Override
    public double toCelsius(double value) {
        return value;
    }

    @Override
    public double toFahrenheit(double value) {
        return value * 1.8 + 32;
    }

    @Override
    public double toKelvin(double value) {
        return value + 273.15;
    }
}
