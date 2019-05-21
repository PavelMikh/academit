package ru.academit.mikhajlov.Converter;

import javax.swing.*;
import java.awt.*;

public class Converter extends JFrame implements Temperatures {
    private JFrame frame;
    JPanel textPanel;
    JPanel functionalPanel;
    JComboBox<String> fromType;
    JComboBox<String> toType;
    JTextField inputField;
    JTextField outputField;
    JButton calculationButton;

    public Converter() {
        //Создаётся окно определённого размера с названием и иконкой.
        frame = new JFrame("Конвертер температур");
        frame.setLocationRelativeTo(null);
        Image image = Toolkit.getDefaultToolkit().getImage("градусник.img");
        frame.setIconImage(image);
        frame.setSize(300, 90);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public void setCelsius(double value) {

    }

    @Override
    public void setFahrenheit(double value) {

    }

    @Override
    public void setKelvin(double value) {

    }
}
