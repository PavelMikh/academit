package ru.academit.mikhajlov.Converter;

import javax.swing.*;
import java.awt.*;

public class TemperatureConverter {
    public TemperatureConverter() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температур");
            frame.setSize(320, 100);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Image image = Toolkit.getDefaultToolkit().getImage("градусник.jpg");
            frame.setIconImage(image);
            frame.add(new FunctionalPanel());
            frame.setVisible(true);
        });
    }
}

