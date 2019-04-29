package ru.academit.mihajlov.Main;

import ru.academit.mihajlov.MyArrayList.MyArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> names = new MyArrayList<>(1);
        MyArrayList<String> names1 = new MyArrayList<>(1);
        names.add("Paul");
        names.add("Mariya");
        names.add("Ivan");
        names.add("Julia");
        names.add("Aleksandr");
        names.add("Irina");
        names.add("Valera");
        names.add("Kristina");
        names.add("Kristina");
        names1.add("Nikolas");
        names1.add("Nikolas1");
        names1.add("Nikolas2");
        names1.add("Nikolas3");
        names1.add("Nikolas4");

        Object[] array = names.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(names.addAll(3, names1));
//        System.out.println(names.addAll(names1));
        System.out.println(names);
        System.out.println(names.containsAll(names1));
        System.out.println(names.removeAll(names1));
        System.out.println(names);
    }
}
