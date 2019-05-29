package ru.academit.mikhajlov.Converter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class FunctionalPanel extends JPanel {

    public FunctionalPanel() {
        //Создаются панель ввода - вывода и функциональная панель. В конструктор передается строчный менеджер компановки.
        JPanel panel = new JPanel(new BorderLayout());
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
        panel.add(inputOutputPanel, BorderLayout.NORTH);
        panel.add(functionalPanel, BorderLayout.CENTER);
        add(panel);

        //Создание объектов - слушателей. Создание таблицы <K, V> K - NAME, V - listener.
        HashMap<String, Converter> converters = new HashMap<>();
        converters.put("Цельсий", new CelsiusConverter());
        converters.put("Фаренгейт", new FahrenheitConverter());
        converters.put("Кельвин", new KelvinConverter());

        calculationButton.addActionListener(e -> {
            try {
                //Вычисление числового значения из поля ввода.
                double number = Double.parseDouble(inputField.getText());
                //Объявление переменной результата.
                double result;
                //Получение значений ключей для поиска нужных объектов - конвертеров в HashMap.
                String fromTypeValue = (String) fromType.getSelectedItem();
                String toTypeValue = (String) toType.getSelectedItem();
                //Вычисление результата конвертации:
                //Случай когда выбранные шкалы совпали.
                if (Objects.equals(fromTypeValue, toTypeValue)) {
                    result = number;
                } else { //Случай с разными шкалами.
                    //Поиск объекта из типа которого нужно переводить.
                    Converter from = converters.get(fromTypeValue);
                    //Получение промежуточного значения в градусах цельсия.
                    double intermediateValue = from.toCelsius(number);
                    //Поиск объекта в тип которого нужно переводить.
                    Converter to = converters.get(toTypeValue);
                    //Вычисление результата.
                    result = to.fromCelsius(intermediateValue);
                }
                //Вывод результата в поле вывода.
                outputField.setText(String.valueOf(result));
                //Обработка случая когда в поле ввода ввели не цифры.
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Температуру нужно вводить цифрами.");
            }
        });
    }
}
