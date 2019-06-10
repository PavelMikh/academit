package ru.academit.mikhajlov.Model;

import java.util.HashMap;

public class Converters {
    private static final HashMap<String, Converter> CONVERTERS = new HashMap<>();

    @SuppressWarnings("unused")
    public Converters() {
        CONVERTERS.put(CelsiusConverter.NAME, new CelsiusConverter());
        CONVERTERS.put(FahrenheitConverter.NAME, new FahrenheitConverter());
        CONVERTERS.put(KelvinConverter.NAME, new KelvinConverter());
    }

    public Converter getConverter(String key) {
        return CONVERTERS.get(key);
    }
}
