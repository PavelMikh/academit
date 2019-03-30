package ru.academit.mikhajlov.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.printf("Передано аргументов: %d. Нужно ввести один аргумент - путь к файлу ", args.length);
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(args[0]), "windows-1251")) {
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
        }
        System.out.println(list);

        // Первый вариант.
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 2 == 0) {
                    list.remove(i);
                    i--;
                }
            }
            System.out.println(list);
        }

        //Второй вариант.
        if (!list.isEmpty()) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) % 2 == 0) {
                    list.remove(i);
                }
            }
            System.out.println(list);
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.indexOf(list.get(i)) == list.lastIndexOf(list.get(i))) {
                    list2.add(list.get(i));
                }
            }
            System.out.println(list2);
        }
    }
}

