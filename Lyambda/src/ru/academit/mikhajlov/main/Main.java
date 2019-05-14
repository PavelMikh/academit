package ru.academit.mikhajlov.main;

import ru.academit.mikhajlov.Person;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Pavel", 33);
        Person person2 = new Person("Aleksey", 26);
        Person person3 = new Person("Tatyana", 29);
        Person person4 = new Person("Aleksandr", 43);
        Person person5 = new Person("Elena", 33);

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        Stream<Person> stream = persons.stream().filter(person -> person.getAge() > 30);
        stream.forEach(System.out::println);
    }
}
