package ru.academit.mikhaylov2.Vector;

import java.util.Arrays;

public class Vector implements Cloneable {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Недопустимое значение размерности вектора.");
        }
        components = new double[n];
    }

    public Vector(Vector vector) {
        this(vector.components);// TODO: 06.02.2019 Проверить копирование и спросить про клонирование.
        if (vector.components.length == 0) {
            throw new IllegalArgumentException("Недопустимое значение размерности вектора.");
        }
//        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    /*@Override
    public Vector clone() { // Можно ли пользоваться таким способом?
        try {
            return (Vector)super.clone();
        }catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }*/

    public Vector(double[] doubles) {
        if (doubles.length == 0) {
            throw new IllegalArgumentException("Недопустимое значение размерности вектора.");
        }
        components = Arrays.copyOf(doubles, doubles.length);
    }

    public Vector(int n, double[] doubles) {
        if (n <= 0) {
            throw new IllegalArgumentException("Недопустимое значение размерности вектора.");
        }
        components = Arrays.copyOf(doubles, n);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < components.length; i++) {
            if (i == 0) {
                sb.append("{");
            }
            sb.append(components[i]);
            if (i < components.length - 1) {
                sb.append(", ");
            }
            if (i == components.length - 1) {
                sb.append("}");
            }
        }
        return sb.toString();
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
        if (this.getSize() < vector.getSize()) {
            components = Arrays.copyOf(components, vector.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void deduction(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            components = Arrays.copyOf(components, vector.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= (vector.components[i]);
        }
    }

    public void multiplicationOfVectorOnScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void getReverseVector() {
        this.multiplicationOfVectorOnScalar(-1);
    }

    public double getVectorLength() {
        double powSum = 0;
        for (double component : components) {
            powSum += Math.pow(component, 2);
        }
        return Math.sqrt(powSum);
    }

    public double getIndexValue(int index) {
        if (index < 0 || index >= components.length) {
            throw new IllegalArgumentException();
        }
        return components[index];
    }

    public void setIndexValue(double number, int index) {
        if (index < 0 || index >= components.length) {
            throw new IllegalArgumentException();
        }
        components[index] = number;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector copyOfVector1 = new Vector(vector1);
        Vector copyOfVector2 = new Vector(vector2);
        copyOfVector1.add(copyOfVector2);
        return new Vector(copyOfVector1.components.length, copyOfVector1.components);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector copyOfVector1 = new Vector(vector1);
        Vector copyOfVector2 = new Vector(vector2);
        copyOfVector1.deduction(copyOfVector2);
        return new Vector(copyOfVector1.components.length, copyOfVector1.components);
    }

    public static double getScalarProductByVectors(Vector vector1, Vector vector2) {
        Vector copyOfVector1 = new Vector(vector1);
        double product = 0;
        if (copyOfVector1.components.length < vector2.components.length) {
            copyOfVector1.components = Arrays.copyOf(vector1.components, vector2.components.length);
        }
        for (int i = 0; i < copyOfVector1.components.length; i++) {
            product += (copyOfVector1.components[i] * vector2.components[i]);
        }
        return product;
    }
}