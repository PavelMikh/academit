package ru.academit.mikhajlov.Model;

import java.util.HashMap;

public class Converters {
    private static final HashMap<String, Converter> CONVERTERS = new HashMap<>();

    @SuppressWarnings("unused")
    public Converters() {
        Converter celsiusConverter = new CelsiusConverter(this);
        Converter fahrenheitConverter = new FahrenheitConverter(this);
        Converter kelvinConverter = new KelvinConverter(this);
    }

    public Converter getConverter(String key) {
        return CONVERTERS.get(key);
    }

    void add(String converterName, Converter converter) {
        CONVERTERS.put(converterName, converter);
    }
}
