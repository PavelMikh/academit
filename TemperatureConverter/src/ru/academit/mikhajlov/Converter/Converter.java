package ru.academit.mikhajlov.Converter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

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


        //Создание объектов - слушателей.
        Listener celsiusListener = new CelsiusListener();
        Listener fahrenheitListener = new FahrenheitListener();
        Listener kelvinListener = new KelvinListener();

        //Создание таблицы <K, V> K - NAME, V - listener.
        HashMap<String, Listener> listeners = new HashMap<>();
        listeners.put(celsiusListener.getName(), celsiusListener);
        listeners.put(fahrenheitListener.getName(), fahrenheitListener);
        listeners.put(kelvinListener.getName(), kelvinListener);


        calculationButton.addActionListener(e -> {
            //Вычисление чисового значения из поля ввода.
            double number = Double.parseDouble(inputField.getText());
            double result;
            if (Objects.equals(fromType.getSelectedItem(), toType.getSelectedItem())) {
                result = number;
            } else {
                //noinspection SuspiciousMethodCalls
                Listener listener = listeners.get(fromType.getSelectedItem());
                LibraryClass library = new LibraryClass();
                result = library.convert(listener, (String) toType.getSelectedItem(), number);
            }
            outputField.setText(String.valueOf(result));
        });
    }
}
