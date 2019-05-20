package ru.academit.mikhajlov.Main;

import ru.academit.mikhajlov.Converter.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("Конвертер температур.");
            window.setSize(277, 90);
            window.setResizable(false);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            window.setVisible(true);

            Image image = Toolkit.getDefaultToolkit().getImage("градусник.jpg");
            window.setIconImage(image);

            JPanel panel1 = new JPanel();
            window.add(panel1);

            JTextField output = new JTextField(10);
            output.setEditable(false);
            panel1.add(output, FlowLayout.LEFT);

            JTextField input = new JTextField(10);
            panel1.add(input, FlowLayout.LEFT);

            window.add(panel1, BorderLayout.NORTH);

            String[] conversionType = {
                    "цельсий - кельвин",
                    "цельсий - фаренгейт",
                    "фаренгейт - цельсий",
                    "фаренгейт - кельвин",
                    "кельвин - цельсий",
                    "кельвин - фаренгейт"
            };

            ActionListener comboBoxListener = e -> {
                try {
                    JComboBox box = (JComboBox) e.getSource();
                    String item = (String) box.getSelectedItem();
                    double number = Double.parseDouble(input.getText());
                    output.setText(new Model(item, number).convert());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(window, "Температуру нужно вводить цифрами.");
                }
            };

            //noinspection unchecked
            JComboBox comboBox = new JComboBox(conversionType);
            comboBox.addActionListener(comboBoxListener);

            JPanel panel2 = new JPanel();
            panel2.add(comboBox, FlowLayout.LEFT);
            window.add(panel2, BorderLayout.CENTER);
        });
    }
}

