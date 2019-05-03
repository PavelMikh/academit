package Main;

import ru.academit.mikhajlov.HashTable.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>(10);
        table.add("Pavel");
        table.add("Pavel");
        table.add("Tanya");
        table.add("Mariya");
        table.add("Vladimir Putin");
        table.add("Dmitriy Medvedev");
        System.out.println(table);
    }
}
