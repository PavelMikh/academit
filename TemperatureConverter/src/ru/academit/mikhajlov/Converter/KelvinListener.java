package ru.academit.mikhajlov.Converter;

public class KelvinListener extends TemperatureAction {
    public KelvinListener(Temperatures temperatures) {
        super(temperatures);
        putValue(NAME, "Кельвин");
    }

    @Override
    public double toCelsius(double value) {
        return value - 273.15;
    }

    @Override
    public double toFahrenheit(double value) {
        return (value - 273.15) * 1.8 + 32;
    }

    @Override
    public double toKelvin(double value) {
        return value;
    }
}
