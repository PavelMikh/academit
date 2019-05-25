package ru.academit.mikhajlov.Converter;

import ru.academit.mikhajlov.Annotation.Annotation;

public class FahrenheitListener implements Listener {
    @Override
    @Annotation.Init(flag = "Цельсий")
    public double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    @Override
    @Annotation.Init(flag = "Фаренгейт")
    public double toFahrenheit(double value) {
        return value;
    }

    @Override
    @Annotation.Init(flag = "Кельвин")
    public double toKelvin(double value) {
        return (value - 32) * 5 / 9 + 273.15;
    }
}
