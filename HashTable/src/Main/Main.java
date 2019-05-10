package Main;

import ru.academit.mikhajlov.HashTable.HashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>(10);
        table.add("Pavel");
        table.add("Tatyana");
        table.add("Maxim");
        table.add("Mariya");
        table.add("Dmitriy Medvedev");
        table.add("uncle Fedor Emelyanenko");
        table.add("Vovka-krab");
        table.add("kot Vasiliy");
        table.add("ave Mariya");
        table.add("hash table");
        table.add("Ma");
        ArrayList<String> list = new ArrayList<>();
        list.add("PAVEL");
        list.add("MARIYA");
        list.add("MA");
        System.out.println(table);
        System.out.println(table.contains("Ma"));
//        System.out.println(table.remove("Vovka-krab"));
//        table.remove("Dmitriy Medvedev");
        Object[] objects = table.toArray();
        System.out.println(Arrays.toString(objects));
        System.out.println(table.containsAll(list));
        System.out.println(table.addAll(list));
        System.out.println(table);
        System.out.println(table.removeAll(list));
        System.out.println(table);
    }
}

