package ru.academit.mikhaylov2.Vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = components;
    }

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

    public int getSize(Vector vector) {
        return vector.components.length;
    }

    public String toString() {
        return Arrays.toString(this.components);
    }

    public Vector getSum(Vector vector) {
        double[] components = new double[Math.min(this.components.length, vector.components.length)];
        for (int i = 0; i < Math.min(this.components.length, vector.components.length); i++) {
            components[i] = this.components[i] + vector.components[i];
        }
        return new Vector(Math.max(this.components.length, vector.components.length), components);
    }

    public Vector getDifference(Vector vector) {
        double[] components = new double[Math.min(this.components.length, vector.components.length)];
        for (int i = 0; i < Math.min(this.components.length, vector.components.length); i++) {
            components[i] = this.components[i] - vector.components[i];
        }
        return new Vector(Math.max(this.components.length, vector.components.length), components);
    }

    public void getMultiplicationOfVectorOnScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }
}
