package ru.academit.mikhajlov.Vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Значение размерности вектора должно быть больше нуля.");
        }
        components = new double[n];
    }

    public Vector(Vector vector) {
        this(vector.components);
    }

    public Vector(double[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Значение размерности вектора должно быть больше нуля.");
        }
        this.components = Arrays.copyOf(numbers, numbers.length);
    }

    public Vector(int n, double[] numbers) {
        if (n <= 0) {
            throw new IllegalArgumentException("Значение размерности вектора должно быть больше нуля.");
        }
        components = Arrays.copyOf(numbers, n);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < components.length - 1; i++) {
            sb.append(components[i]).append(", ");
        }
        return sb.append(components[components.length - 1]).append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector vector = (Vector) o;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public void add(Vector vector) {
        if (this.components.length < vector.components.length) {
            this.components = Arrays.copyOf(this.components, vector.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            this.components[i] += vector.components[i];
        }
    }

    public void deduction(Vector vector) {
        if (this.components.length < vector.components.length) {
            this.components = Arrays.copyOf(this.components, vector.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            this.components[i] -= vector.components[i];
        }
    }

    public void multiplicationOnScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void reverse() {
        this.multiplicationOnScalar(-1);
    }

    public double getLength() {
        double powSum = 0;
        for (double component : components) {
            powSum += Math.pow(component, 2);
        }
        return Math.sqrt(powSum);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива.");
        }
        return components[index];
    }

    public void setComponent(double number, int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива.");
        }
        components[index] = number;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector1Copy = new Vector(vector1);
        vector1Copy.add(vector2);
        return vector1Copy;

    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector1Copy = new Vector(vector1);
        vector1Copy.deduction(vector2);
        return vector1Copy;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double product = 0;
        int min = Math.min(vector1.components.length, vector2.components.length);
        for (int i = 0; i < min; i++) {
            product += (vector1.components[i] * vector2.components[i]);
        }
        return product;
    }
}