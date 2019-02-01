package ru.academit.mikhaylov2.Vector;

public class Vector {
    private int n;
    private double[] vectorComponents;

    public Vector(int n) {
        try {
            this.n = n;
            if (n <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Размерность вектора должна быть болше нуля.");
            throw e;
        }
    }

    public Vector(Vector vector) {
        this.n = vector.getN();
        this.vectorComponents = vector.getVectorComponents();
    }

    public Vector(double[] vectorComponents) {
        this.vectorComponents = vectorComponents;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double[] getVectorComponents() {
        return vectorComponents;
    }

    public void setVectorComponents(double[] vectorComponents) {
        this.vectorComponents = vectorComponents;
    }
}
