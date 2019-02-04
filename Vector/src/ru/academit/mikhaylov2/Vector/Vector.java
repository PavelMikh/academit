package ru.academit.mikhaylov2.Vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        try {
            if (n <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Размерность вектора должна быть болше нуля.");
            throw e;
        }
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

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = components;
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.components);
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
        return this.getSize() == vector.getSize() && this.getComponents() == vector.getComponents();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public void getsum(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            components = Arrays.copyOf(components, vector.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void getDifference(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            components = Arrays.copyOf(components, vector.components.length);
        }
        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
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
            powSum = Math.pow(component, 2);
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
}