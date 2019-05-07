package Main;

import ru.academit.mikhajlov.HashTable.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>(10);
        table.add("Pavel");
        table.add("Tatyana");
        table.add("Maxim");
        table.add("Mariya");
        table.add("Dmitriy Medvedev");
        table.add("uncle Fedor Emelyanenko");
        table.add("kukuha edet");
        table.add("Vovka-krab");
        table.add("kot Vasiliy");
        table.add("deva Mariya");
        table.add("hash tablitsa");
        table.add("Ma");
        System.out.println(table);
        System.out.println(table.contains("Ma"));
        System.out.println(table.remove("Vovka-krab"));
        table.remove("Dmitriy Medvedev");
        System.out.println(table);
    }
}

