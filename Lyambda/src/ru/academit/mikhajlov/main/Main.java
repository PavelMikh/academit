package ru.academit.mikhajlov.main;

import ru.academit.mikhajlov.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Pavel", 33);
        Person person2 = new Person("Aleksey", 26);
        Person person3 = new Person("Tatyana", 29);
        Person person4 = new Person("Aleksandr", 43);
        Person person5 = new Person("Aleksandr", 31);
        Person person6 = new Person("Elena", 33);
        Person person7 = new Person("Kirill", 3);
        Person person8 = new Person("Leyla", 16);
        Person person9 = new Person("Grigoriy", 6);

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);
        persons.add(person8);
        persons.add(person9);

        Stream<String> stream = persons.stream()
                .map(Person::getName)
                .distinct();
        System.out.printf("Names: %s. ", stream.collect(Collectors.joining(", ")));
        System.out.println();

        System.out.printf("Average age of persons under 18 = %s.%n", persons.stream()
                .filter(person -> person.getAge() < 18)
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0));

        //Map<K, V> K - names, V - averageAge
        Map<String, Double> map = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        map.forEach((name, age) -> System.out.printf("name %11s: average age = %s%n", name, age));

        System.out.println("List of people from 20 to 45 years sorted descending: " + persons.stream()
                .filter(person -> person.getAge() >= 20 && person.getAge() <= 45)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .map(Person::getName)
                .collect(Collectors.joining(", ")));

        //Creating an infinite stream of square number roots
        System.out.println("Enter the count of numbers you want to calculate: ");
        DoubleStream sqrt = DoubleStream.iterate(0, number -> number + 1)
                .map(Math::sqrt)
                .limit(new Scanner(System.in).nextInt());
        sqrt.forEach(System.out::println);

        //Creating an infinite stream of Fibonacci numbers
        System.out.println("Enter the count of Fibonacci numbers you want calculate: ");
        LongStream fibonacci = LongStream.iterate(0, number -> number + 1)
                .map(number -> (long) (Math.pow(((Math.sqrt(5) + 1) / 2), number) / Math.sqrt(5) + 0.5))
                .limit(new Scanner(System.in).nextInt());
        fibonacci.forEach(System.out::println);
    }
}
