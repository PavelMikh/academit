package ru.academit.mikhajlov.Controller;

import ru.academit.mikhajlov.Converter.*;

public class Controller {

    public static double toConvert(double value, Converter converterFrom, Converter converterTo) {
        double tmp = converterFrom.toCelsius(value);
        return converterTo.fromCelsius(tmp);
    }
}
