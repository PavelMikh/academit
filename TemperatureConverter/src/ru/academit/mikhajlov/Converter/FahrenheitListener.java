package ru.academit.mikhajlov.Converter;

import ru.academit.mikhajlov.Main.TemperatureConverter;

public class FahrenheitListener extends Listener {
    @TemperatureConverter.Init(flag = "Цельсий")
    public double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    @TemperatureConverter.Init(flag = "Фаренгейт")
    public double toFahrenheit(double value) {
        return value;
    }

    @TemperatureConverter.Init(flag = "Кельвин")
    public double toKelvin(double value) {
        return (value - 32) * 5 / 9 + 273.15;
    }
}
