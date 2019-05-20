package ru.academit.mikhajlov.Converter;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class TemperatureAction extends AbstractAction {
    private Temperatures temperatures;

    protected TemperatureAction(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public void actionPerformed(ActionEvent e) {
        double value = temperatures.getValue();
        temperatures.setCelsius(toCelsius(value));
        temperatures.setFahrenheit(toFahrenheit(value));
        temperatures.setKelvin(toKelvin(value));
    }

    public abstract double toCelsius(double value);

    public abstract double toFahrenheit(double value);

    public abstract double toKelvin(double value);
}
