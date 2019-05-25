package ru.academit.mikhajlov.Converter;

import ru.academit.mikhajlov.Annotation.Annotation;

public class FahrenheitListener implements Listener {
    @Annotation.Init(flag = "Цельсий")
    public double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    @Annotation.Init(flag = "Фаренгейт")
    public double toFahrenheit(double value) {
        return value;
    }

    @Annotation.Init(flag = "Кельвин")
    public double toKelvin(double value) {
        return (value - 32) * 5 / 9 + 273.15;
    }
}
