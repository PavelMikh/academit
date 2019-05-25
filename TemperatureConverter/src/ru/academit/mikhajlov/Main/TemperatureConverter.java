package ru.academit.mikhajlov.Main;

import ru.academit.mikhajlov.Converter.Converter;

import javax.swing.*;
import java.awt.*;

public class TemperatureConverter {
    public static void main(String[] args) {
        new TemperatureConverter();
    }

    private TemperatureConverter() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температур");
            frame.setSize(320, 100);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Image image = Toolkit.getDefaultToolkit().getImage("градусник.jpg");
            frame.setIconImage(image);
            frame.add(new Converter());
            frame.setVisible(true);
        });
    }
}

