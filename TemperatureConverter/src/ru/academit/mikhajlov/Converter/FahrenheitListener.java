package ru.academit.mikhajlov.Converter;

public class FahrenheitListener extends TemperatureAction {
    public FahrenheitListener(Temperatures temperatures) {
        super(temperatures);
        putValue(NAME, "Фаренгейт");
    }

    @Override
    public double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    @Override
    public double toFahrenheit(double value) {
        return value;
    }

    @Override
    public double toKelvin(double value) {
        return (value - 32) * 5 / 9 + 273.15;
    }
}
