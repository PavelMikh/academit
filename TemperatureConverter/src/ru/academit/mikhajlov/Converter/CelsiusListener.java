package ru.academit.mikhajlov.Converter;

import ru.academit.mikhajlov.Main.TemperatureConverter;

public class CelsiusListener extends Listener {
    private static final String NAME = "Цельсий";

    CelsiusListener() {
        super(NAME);
    }

    @TemperatureConverter.Flag(flag = "Цельсий")
    public double toCelsius(double value) {
        return value;
    }

    @TemperatureConverter.Flag(flag = "Фаренгейт")
    public double toFahrenheit(double value) {
        return value * 1.8 + 32;
    }

    @TemperatureConverter.Flag(flag = "Кельвин")
    public double toKelvin(double value) {
        return value + 273.15;
    }

    @Override
    String getName() {
        return NAME;
    }
}
