package ru.academit.mihajlov.Main;

import ru.academit.mihajlov.MyArrayList.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> names = new MyArrayList<>();
        MyArrayList<String> names1 = new MyArrayList<>(20);
        names.add("Paul");
        names.add("Mariya");
        names.add("Ivan");
        names.add("Julia");
        names.add("Aleksandr");
        names.add("Irina");
        names.add("Valera");
        names.add("Kristina");
        names.add("Kristina");
        names.add("Ivan");
        names1.add("Nikolas");
        names1.add("Nikolas1");
        names1.add("Nikolas2");
        names1.add("Nikolas3");
        names1.add("Nikolas4");

        System.out.println(names);
        names1.trimToSize();
        System.out.println(names.indexOf("Ivan"));
        System.out.println(names.lastIndexOf("Ivan"));
        System.out.println(names.indexOf("jhbhb"));
        names.addAll(10, names1);
        names.add(0, "ijiji");
        System.out.println(names);
        names.set(0, "element1");
        System.out.println(names);
    }
}
