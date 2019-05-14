package Main;

import ru.academit.mikhajlov.HashTable.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>(10);
        HashTable<String> table1 = new HashTable<>();
        table1.add("Pavel");
        table1.add(null);
        table1.add(null);
        table1.add("Mariya");
        table.add("Mariya");
//        table.add(null);
        table1.add("Vovka-krab");
        table.add("kot Vasiliy");
        System.out.println(table);
        System.out.println(table1);
        table1.addAll(table);
        System.out.println(table1);
        System.out.println(table1.removeAll(table));
        System.out.println(table1);
        System.out.println(table1.size());
    }
}

