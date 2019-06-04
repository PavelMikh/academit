package ru.academit.mikhajlov.Converter;

import java.util.HashMap;

class Converters {
    private static final HashMap<String, Converter> CONVERTERS = new HashMap<>();

    Converters() {
        Converter celsiusConverter = new CelsiusConverter(this);
        Converter fahrenheitConverter = new FahrenheitConverter(this);
        Converter kelvinConverter = new KelvinConverter(this);
    }

    Converter getConverter(String key) {
        return CONVERTERS.get(key);
    }

    void add(String converterName, Converter converter) {
        CONVERTERS.put(converterName, converter);
    }
}
