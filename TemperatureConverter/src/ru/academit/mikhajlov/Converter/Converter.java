package ru.academit.mikhajlov.Converter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Converter extends JPanel {

    public Converter() {
        //Создаются панель ввода - вывода и функциональная панель. В конструктор передается строчный менеджер компановки.
        JPanel converter = new JPanel(new BorderLayout());
        JPanel inputOutputPanel = new JPanel();
        inputOutputPanel.getPreferredSize();
        JPanel functionalPanel = new JPanel();
        functionalPanel.getPreferredSize();
        //На панель ввода - вывода добавляются соответственно поля ввода и вывода.
        JTextField inputField = new JTextField(12);
        JTextField outputField = new JTextField(12);
        outputField.setEditable(false);//поле вывода делается нередактируемое.
        inputOutputPanel.add(inputField);
        inputOutputPanel.add(outputField);

        //На функциональную панель добавляются кнопка для вычисления результата и два выпадающих списка.
        final String[] temperatureType = {"Цельсий", "Фаренгейт", "Кельвин"};
        JComboBox<String> fromType = new JComboBox<>(temperatureType);
        JComboBox<String> toType = new JComboBox<>(temperatureType);
        JButton calculationButton = new JButton("Вычислить");
        functionalPanel.add(fromType);
        functionalPanel.add(toType);
        functionalPanel.add(calculationButton);
        converter.add(inputOutputPanel, BorderLayout.NORTH);
        converter.add(functionalPanel, BorderLayout.CENTER);
        add(converter);

        //Создание объектов - слушателей. Создание таблицы <K, V> K - NAME, V - listener.
        HashMap<String, Listener> listeners = new HashMap<>();
        listeners.put("Цельсий", new CelsiusListener());
        listeners.put("Фаренгейт", new FahrenheitListener());
        listeners.put("Кельвин", new KelvinListener());

        calculationButton.addActionListener(e -> {
            try {
                //Вычисление чисового значения из поля ввода.
                double number = Double.parseDouble(inputField.getText());
                double result;
                String type = (String) fromType.getSelectedItem();
                Listener listener = listeners.get(type);
                LibraryClass library = new LibraryClass();
                result = library.convert(listener, (String) toType.getSelectedItem(), number);
                outputField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(converter, "Температуру нужно вводить цифрами.");
            }
        });
    }
}
