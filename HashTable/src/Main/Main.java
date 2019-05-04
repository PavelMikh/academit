package Main;

import ru.academit.mikhajlov.HashTable.HashTable;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>(10);
        table.add("Pavel");
        table.add("Tatyana");
        table.add("Maxim");
        table.add("Mariya");
        table.add("Dmitriy Medvedev");
        System.out.println(table);
        Iterator iterator = table.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
