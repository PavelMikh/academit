package ru.academit.mikhajlov.Converter;

abstract class Listener {
    public abstract double toCelsius(double value);

    public abstract double toFahrenheit(double value);

    public abstract double toKelvin(double value);
}
