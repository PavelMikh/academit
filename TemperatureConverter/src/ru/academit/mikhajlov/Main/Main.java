package ru.academit.mikhajlov.Main;

import ru.academit.mikhajlov.Converter.TemperatureConverter;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        TemperatureConverter temperatureConverter = new TemperatureConverter();
    }
}
