package ru.academit.mikhajlov.Converter;

import ru.academit.mikhajlov.Main.TemperatureConverter;

public class FahrenheitListener extends Listener {
    private static final String NAME = "Фаренейт";

    FahrenheitListener() {
        super(NAME);
    }

    @TemperatureConverter.Flag(flag = "Цельсий")
    public double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    @TemperatureConverter.Flag(flag = "Фаренгейт")
    public double toFahrenheit(double value) {
        return value;
    }

    @TemperatureConverter.Flag(flag = "Кельвин")
    public double toKelvin(double value) {
        return (value - 32) * 5 / 9 + 273.15;
    }

    @Override
    String getName() {
        return NAME;
    }
}
