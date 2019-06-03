package ru.academit.mikhajlov.Converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Objects;

public class TemperatureConverter {
    public TemperatureConverter() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температур");
            frame.setSize(320, 100);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Image img = Toolkit.getDefaultToolkit().getImage("Термометр.jpeg");
            frame.setIconImage(img);//Создаются панель ввода - вывода и функциональная панель. В конструктор передается строчный менеджер компановки.
            JPanel panel = new JPanel(new BorderLayout());
            JPanel inputOutputPanel = new JPanel();
            inputOutputPanel.getPreferredSize();
            JPanel functionalPanel = new JPanel();
            functionalPanel.getPreferredSize();
            //На панель ввода - вывода добавляются соответственно поля ввода и вывода.
            JTextField inputField = new HintTextField("Введите значение");
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

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    //Поле ввода с подсказкой.
    private class HintTextField extends JTextField implements FocusListener {
        private final String text;
        private boolean showingText;

        public HintTextField(final String text) {
            super(text);
            this.text = text;
            this.showingText = true;
            super.addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent focusEvent) {
            if (this.getText().isEmpty()) {
                super.setText("");
                showingText = false;
            }
        }

        @Override
        public void focusLost(FocusEvent focusEvent) {
            if (this.getText().isEmpty()) {
                super.setText(text);
                showingText = true;
            }
        }

        @Override
        public String getText() {
            return showingText ? "" : super.getText();
        }
    }
}
