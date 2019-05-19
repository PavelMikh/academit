package ru.academit.mikhajlov;

import ru.academit.mikhajlov.Vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создаю вектор 1 размерности 2 с нулевыми компонентами: ");
        Vector vector1 = new Vector(2);
        System.out.println(vector1.toString());

        System.out.println("Теперь создаю вектор 2 - его копию при помощи конструктора копирования: ");
        Vector vector2 = new Vector(vector1);
        System.out.println(vector2.toString());
        System.out.println("Хэшкод вектора 1 = " + vector1.hashCode());
        System.out.println("Хэшкод вектора 2 = " + vector2.hashCode());
        System.out.println("Результат сравнения ссылок первого и второго векторов = " + (vector1 == vector2));
        System.out.println("Результат проверки равенства их компонент = " + vector1.equals(vector2));

        System.out.println("Создаю массив вещественных чисел произвольной длины.");
        double[] numbers = new double[]{1, 2, 3};
        System.out.println(Arrays.toString(numbers));
        System.out.println("Создаю вектор 3 и заполняю его компоненты значениями этого массива:  ");
        Vector vector3 = new Vector(numbers);
        System.out.println(vector3.toString());

        System.out.println("Создаю вектор 4 и в конструкторе задаю его размерность большей чем длина массива " +
                "и заполняю его компоненты значениями того же массива: ");
        Vector vector4 = new Vector(4, numbers);
        System.out.println(vector4.toString());

        System.out.println("Сравниваю хэшкод и значения вектора 4 с вектором 3:  ");
        System.out.println("Хэшкод вектора 4 = " + vector4.hashCode());
        System.out.println("Хэшкод вектора 3 = " + vector3.hashCode());
        System.out.println("Результат проверки равенства их компонент = " + vector4.equals(vector3));

        System.out.println("Изменяю компоненту вектора 4 по индексу 3 на число 8 и прибавляю к вектору 3 вектор 4:  ");
        vector4.setComponent(8, 3);
        vector3.add(vector4);
        System.out.println(vector3.toString());

        System.out.println("Вычитаю из вектора 3 вектор 4: ");
        vector3.deduction(vector4);
        System.out.println(vector3.toString());

        System.out.println("Результат умножения вектора 3 на число 5: ");
        vector3.multiplicationOnScalar(5);
        System.out.println(vector3.toString());

        System.out.println("Делаю разворот вектора 3: ");
        vector3.reverse();
        System.out.println(vector3.toString());

        System.out.println("Получаю длину вектора 3: ");
        System.out.println(vector3.getLength());

        System.out.println("Получаю значение компоненты по индексу 0 у вектора 3: ");
        System.out.println(vector3.getComponent(0));

        System.out.println("Создаю вектор 7 и заполняю его компоненты значениями массива: ");
        Vector vector7 = new Vector(numbers);
        System.out.println(vector7.toString());

        System.out.println("Получаю вектор 5 - сумма вектора 1 и вектора 4: ");
        Vector vector5 = Vector.getSum(vector1, vector4);
        System.out.println(vector5.toString());

        System.out.println("Получаю вектор 6 - разность вектора 5 и вектора 7: ");
        Vector vector6 = Vector.getDifference(vector5, vector7);
        System.out.println(vector6.toString());

        System.out.println("Скалярное произведение векторов 5 и 7 = ");
        System.out.println(Vector.getScalarProduct(vector5, vector7));

        System.out.println("Размерность вектора 6 = ");
        System.out.println(vector6.getSize());
    }
}
