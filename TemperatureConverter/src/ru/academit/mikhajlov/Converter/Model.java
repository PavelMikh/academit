package ru.academit.mikhajlov.Converter;

import java.util.Objects;

public class Model implements Converter {

    public Model() {
    }

    @Override
    public String convert(String conversionType, double value) {
        if (Objects.equals(conversionType, "цельсий - кельвин")) {
            return String.format("%f", value + 273.15);
        }
        if (Objects.equals(conversionType, "цельсий - фаренгейт")) {
            return String.format("%f", value * 1.8 + 32);
        }
        if (Objects.equals(conversionType, "фаренгейт - цельсий")) {
            return String.format("%f", (value - 32) * 5 / 9);
        }
        if (Objects.equals(conversionType, "фаренгейт - кельвин")) {
            return String.format("%f", (value - 32) * 5 / 9 + 273.15);
        }
        if (Objects.equals(conversionType, "кельвин - цельсий")) {
            return String.format("%f", value - 273.15);
        }
        if (Objects.equals(conversionType, "кельвин - фаренгейт")) {
            return String.format("%f", (value - 273.15) * 1.8 + 32);
        }
        return String.format("%f", value);
    }
}
