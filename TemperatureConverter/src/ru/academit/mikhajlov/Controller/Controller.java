package ru.academit.mikhajlov.Controller;

import ru.academit.mikhajlov.Model.*;

public class Controller {
    private Converters converters = new Converters();

    public double toConvert(double value, String fromTypeValue, String toTypeValue) {
        double tmp = converters.getConverter(fromTypeValue).toCelsius(value);
        return converters.getConverter(toTypeValue).fromCelsius(tmp);
    }
}
