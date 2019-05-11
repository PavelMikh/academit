package ru.academit.mihajlov.Main;

import ru.academit.mihajlov.MyArrayList.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> names = new MyArrayList<>();
        MyArrayList<String> names1 = new MyArrayList<>(20);
        names.add("Ivan");
        names.add("Paul");
        names.add("Ivan");
        names.add("Mariya");
        names.add("Julia");
        names.add("Aleksandr");
        names.add("Irina");
        names.add("Ivan");
        names.add("Valera");
        names.add("Kristina");
        names.add("Ivan");
        names.add("Kristina");
        names.add("Ivan");
        names1.add("Nikolas");
        names1.add("Nikolas1");
        names1.add("Nikolas2");
        names1.add("Nikolas3");
        names1.add("Nikolas4");

        System.out.println(names1);
        System.out.println(names1.addAll(names));
        System.out.println(names1.addAll(names));
        System.out.println(names1);
        System.out.println(names1.removeAll(names));
        System.out.println(names1);
    }
}
