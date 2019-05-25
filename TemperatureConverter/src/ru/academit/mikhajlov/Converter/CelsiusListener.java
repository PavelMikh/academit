package ru.academit.mikhajlov.Converter;

import ru.academit.mikhajlov.Annotation.Annotation;

public class CelsiusListener implements Listener {
    @Annotation.Init(flag = "Цельсий")
    public double toCelsius(double value) {
        return value;
    }

    @Annotation.Init(flag = "Фаренгейт")
    public double toFahrenheit(double value) {
        return value * 1.8 + 32;
    }

    @Annotation.Init(flag = "Кельвин")
    public double toKelvin(double value) {
        return value + 273.15;
    }
}
