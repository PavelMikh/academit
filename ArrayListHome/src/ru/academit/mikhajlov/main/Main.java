package ru.academit.mikhajlov.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.printf("Передано аргументов: %d. Нужно ввести один аргумент - путь к файлу ", args.length);
            return;
        }

        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(args[0]), "windows-1251")) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }
        System.out.println(list);

        // Первый вариант.
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(5, 2, 8, 5, 9, 14, 4, 2, 15, 9, 22, 10));
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) % 2 == 0) {
                numbersList.remove(i);
                i--;
            }
        }
        System.out.println(numbersList);

        //Второй вариант.
        for (int i = numbersList.size() - 1; i >= 0; i--) {
            if (numbersList.get(i) % 2 == 0) {
                numbersList.remove(i);
            }
        }
        System.out.println(numbersList);

        ArrayList<Integer> list2 = new ArrayList<>();
        for (Integer integer : numbersList) {
            if (!list2.contains(integer)) {
                list2.add(integer);
            }
        }
        System.out.println(list2);
    }
}

