package ru.academit.mikhajlov;

import ru.academit.mikhajlov.SinglyLincedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> numbers = new SinglyLinkedList<>();
        numbers.addHead(54);
        numbers.addHead(null);
        numbers.add(2, 8);
        numbers.add(3, null);
        numbers.add(4, 10);

//        System.out.println(numbers.getData(3));
//        System.out.println(numbers.deleteByValue(null));
//        System.out.println(numbers.removeHead());
//        numbers.reverse();
        SinglyLinkedList<Integer> copy = numbers.copy();
//        SinglyLinkedList<Integer> copy1 = new SinglyLinkedList<>();
//        System.out.println(numbers);
//        System.out.println(copy1);
        System.out.println(copy);
//        copy1.reverse();
    }
}
