package ru.academit.mikhajlov.Main;

import ru.academit.mikhajlov.SinglyLincedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> numbers = new SinglyLinkedList<>();
        numbers.addHead(54);
        numbers.add(1, 8);
        numbers.add(2, 10);
        numbers.add(1, 7);
//        System.out.println(numbers.valueRemove(54));
//        System.out.println(numbers.firstItemRemove());
        numbers.reverse();
        SinglyLinkedList<Integer> copy = numbers.copy();
        numbers.copy();
//        System.out.println(numbers);
        System.out.println(copy);
    }
}
