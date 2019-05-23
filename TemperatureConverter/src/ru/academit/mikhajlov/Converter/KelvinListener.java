package ru.academit.mikhajlov.Converter;

import ru.academit.mikhajlov.Main.TemperatureConverter;

public class KelvinListener extends Listener {
    private static final String NAME = "Кельвин";

    KelvinListener() {
        super(NAME);
    }

    @TemperatureConverter.Flag(flag = "Цельсий")
    public double toCelsius(double value) {
        return value - 273.15;
    }

    @TemperatureConverter.Flag(flag = "Фаренгейт")
    public double toFahrenheit(double value) {
        return (value - 273.15) * 1.8 + 32;
    }

    @TemperatureConverter.Flag(flag = "Кельвин")
    public double toKelvin(double value) {
        return value;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
