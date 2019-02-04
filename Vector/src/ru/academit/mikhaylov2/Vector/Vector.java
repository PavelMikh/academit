package ru.academit.mikhaylov2.Vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.components = new double[n];
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        this.components = components;
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.components = Arrays.copyOf(components, n);
    }

    private double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = Arrays.copyOf(components, components.length);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.components.length; i++) {
            sb.append(components[i]);
            if (i < components.length - 1) {
                sb.append(", ");
            }
        }
        return "{" + sb.toString() + "}";
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
        return Arrays.equals(this.components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public void getAdd(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            components = Arrays.copyOf(components, vector.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void getDeduction(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            components = Arrays.copyOf(components, vector.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            components[i] += (vector.components[i] * (-1));
        }
    }

    public void getMultiplicationOfVectorOnScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void getReverseVector() {
        for (int i = 0; i < components.length; i++) {
            components[i] *= -1;
        }
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

    public void setComponentByIndex(double number, int index) {
        if (index < 0 || index >= components.length) {
            throw new IllegalArgumentException();
        }
        components[index] = number;
    }

    public static Vector getSum(Vector vector, Vector vector1) {
        if (vector.components.length < vector1.components.length) {
            vector.components = Arrays.copyOf(vector.components, vector1.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            vector.components[i] += vector1.components[i];
        }
        return new Vector(vector.components.length, vector.components);
    }

    public static Vector getDifference(Vector vector, Vector vector1) {
        if (vector.components.length < vector1.components.length) {
            vector.components = Arrays.copyOf(vector.components, vector1.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            vector.components[i] += (vector1.components[i] * (-1));
        }
        return new Vector(vector.components.length, vector.components);
    }

    public static double getScalarProductByVectors(Vector vector, Vector vector1) {
        double product = 0;
        if (vector.components.length < vector1.components.length) {
            vector.components = Arrays.copyOf(vector.components, vector1.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            product += (vector.components[i] * vector1.components[i]);
        }
        return product;
    }
}