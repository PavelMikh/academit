package ru.academit.mikhajlov.View;

import ru.academit.mikhajlov.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class TemperatureConverter {
    public TemperatureConverter() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температур");
            frame.setSize(320, 110);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Image img = Toolkit.getDefaultToolkit().getImage("Градусник.jpg");
            frame.setIconImage(img);
            frame.setVisible(true);
            frame.requestFocus();
            JPanel panel = new JPanel(new BorderLayout());
            frame.add(panel);

            //Создаются панель ввода - вывода и функциональная панель. В конструктор передается строчный менеджер компановки.
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

            calculationButton.addActionListener(e -> {
                try {
                    //Перевод строкового значения из поля ввода в числовое.
                    double number = Double.parseDouble(inputField.getText());
                    //Получение значений ключей для поиска нужных объектов - конвертеров.
                    String fromTypeValue = (String) fromType.getSelectedItem();
                    String toTypeValue = (String) toType.getSelectedItem();
                    //Вычисление результата конвертации:
                    //Объявление переменной результата.
                    double result;
                    //Случай когда выбранные шкалы совпали.
                    if (Objects.equals(fromTypeValue, toTypeValue)) {
                        result = number;
                    } else { //Случай с разными шкалами.
                        //Вычисление результата.
                        result = new Controller().toConvert(number, fromTypeValue, toTypeValue);
                    }
                    //Вывод результата в поле вывода.
                    outputField.setText(String.valueOf(result));
                    //Обработка случая когда в поле ввода ввели не цифры.
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Температуру нужно вводить цифрами.");
                }
            });
        });
    }

    //Поле ввода с подсказкой.
    private class HintTextField extends JTextField implements FocusListener {
        private final String text;
        private boolean showingText;

        HintTextField(final String text) {
            super(text);
            this.text = text;
            this.showingText = true;
            super.addFocusListener(this);
            super.getPreferredSize();
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
