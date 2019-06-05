package ru.academit.mikhajlov.Controller;

import ru.academit.mikhajlov.Model.*;

public class Controller {
    public static double toConvert(double value, String fromTypeValue, String toTypeValue) {
        Converters converters = new Converters();
        double tmp = converters.getConverter(fromTypeValue).toCelsius(value);
        return converters.getConverter(toTypeValue).fromCelsius(tmp);
    }
}
