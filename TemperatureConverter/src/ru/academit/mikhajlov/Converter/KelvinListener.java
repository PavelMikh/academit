package ru.academit.mikhajlov.Converter;

import ru.academit.mikhajlov.Main.TemperatureConverter;

public class KelvinListener extends Listener {
    @TemperatureConverter.Init(flag = "Цельсий")
    public double toCelsius(double value) {
        return value - 273.15;
    }

    @TemperatureConverter.Init(flag = "Фаренгейт")
    public double toFahrenheit(double value) {
        return (value - 273.15) * 1.8 + 32;
    }

    @TemperatureConverter.Init(flag = "Кельвин")
    public double toKelvin(double value) {
        return value;
    }
}
