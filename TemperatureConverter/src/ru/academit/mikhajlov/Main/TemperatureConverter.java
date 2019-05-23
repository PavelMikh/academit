package ru.academit.mikhajlov.Main;

import ru.academit.mikhajlov.Converter.Converter;

import javax.swing.*;
import java.awt.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TemperatureConverter {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Flag {
        String flag();
    }

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

