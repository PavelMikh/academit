package ru.academit.mikhajlov.Converter;

abstract class Listener {
    private final String NAME;

    Listener(String name) {
        NAME = name;
    }

    abstract String getName();
}
