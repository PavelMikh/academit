package ru.academit.mikhajlov.matrix;

import ru.academit.mikhajlov.Vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Высота и ширина матрицы должны быть больше нуля.");
        }
        Vector[] rows = new Vector[height];
        for (int i = 0; i < height; i++) {
            rows[i] = new Vector(width);
        }
        this.rows = rows;
    }

    public Matrix(Matrix matrix) {
        this(matrix.rows);
    }

    public Matrix(double[][] arrays) {
        if (arrays == null) {
            throw new NullPointerException("Входной массив не должен иметь значение null.");
        }
        if (arrays.length == 0) {
            throw new IllegalArgumentException("Входной массив чисел не может иметь размерность 0.");
        }
        for (double[] row : arrays) {
            if (row.length == 0) {
                throw new IllegalArgumentException("Строки входного массива должны иметь длину больше нуля.");
            }
        }
        int maxRowLength = 0;
        for (double[] array : arrays) {
            if (array.length > maxRowLength) {
                maxRowLength = array.length;
            }
        }
        Vector[] rows = new Vector[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            rows[i] = new Vector(maxRowLength, arrays[i]);
        }
        this.rows = rows;
    }

    public Matrix(Vector[] rows) {
        if (rows == null) {
            throw new NullPointerException("Входной массив не должен иметь значение null.");
        }
        if (rows.length == 0) {
            throw new IllegalArgumentException("Размер массива векторов должен быть больше нуля.0");
        }
        int maxRowLength = 0;
        for (Vector row : rows) {
            if (row.getSize() > maxRowLength) {
                maxRowLength = row.getSize();
            }
        }
        Vector[] copyRows = new Vector[rows.length];
        for (int i = 0; i < rows.length; i++) {
            double[] array = new double[maxRowLength];
            for (int j = 0; j < rows[i].getSize(); j++) {
                array[j] = rows[i].getComponent(j);
            }
            copyRows[i] = new Vector(maxRowLength, array);
        }
        this.rows = copyRows;
    }

    public int getRowsCount() {
        return this.rows.length;
    }

    public int getColumnsCount() {
        return this.rows[0].getSize();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < this.rows.length - 1; i++) {
            stringBuilder.append(this.rows[i].toString()).append(", ");
        }
        return stringBuilder.append(rows[rows.length - 1]).append("}").toString();
    }

    public Vector getRow(int rowIndex) {
        if (rowIndex >= getRowsCount() || rowIndex < 0) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы.");
        }
        return new Vector(this.rows[rowIndex]);
    }

    public void setRow(int rowIndex, Vector row) {
        if (rowIndex >= getRowsCount() || rowIndex < 0) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы.");
        }
        if (row.getSize() == 0) {
            throw new IllegalArgumentException("Передаваемый вектор должен иметь размерность больше нуля.");
        }
        this.rows[rowIndex] = new Vector(row);
    }

    public Vector getColumn(int componentIndex) {
        if (componentIndex >= getColumnsCount() || componentIndex < 0) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы.");
        }
        Vector column = new Vector(getRowsCount());
        for (int i = 0; i < column.getSize(); i++) {
            column.setComponent(this.rows[i].getComponent(componentIndex), i);
        }
        return column;
    }

    public void transposition() {
        Vector[] tmp = new Vector[getColumnsCount()];
        for (int i = 0; i < getColumnsCount(); i++) {
            tmp[i] = this.getColumn(i);
        }
        this.rows = tmp;
    }

    public void multiplicationOnScalar(double scalar) {
        for (Vector line : this.rows) {
            line.multiplicationOnScalar(scalar);
        }
    }

    public double getDeterminant() {
        int width = getColumnsCount();
        int height = getRowsCount();

        if (height != width) {
            throw new IllegalArgumentException("Высота и ширина матрицы должны быть одинаковые.");
        }
        if (height == 1) {
            return getRow(0).getComponent(0);
        }
        if (height == 2) {
            return (this.rows[0].getComponent(0) * this.rows[1].getComponent(1)) -
                    (this.rows[0].getComponent(1) * this.rows[1].getComponent(0));
        }
        Matrix copy = new Matrix(this);
        double determinant = 0;
        for (int i = 0; i < width; i++) {
            double[][] tmp = new double[height - 1][width - 1];
            for (int j = 1; j < height; j++) {
                int columnIndex = 0;
                for (int m = 0; m < height; m++) {
                    if (m == i) {
                        continue;
                    }
                    tmp[j - 1][columnIndex] = copy.rows[j].getComponent(m);
                    columnIndex++;
                }
            }
            determinant += copy.rows[0].getComponent(i) * Math.pow(-1, i) * new Matrix(tmp).getDeterminant();
        }
        return determinant;
    }

    public Vector getMultiplicationOnVector(Vector vector) {
        int length = vector.getSize();
        if (getColumnsCount() != length) {
            throw new IllegalArgumentException("Ширина матрицы и размерность вектора должны быть равны.");
        }
        Vector result = new Vector(getRowsCount());
        for (int i = 0; i < length; i++) {
            result.setComponent(Vector.getScalarProduct(rows[i], vector), i);
        }
        return result;
    }

    public void add(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() || getRowsCount() != matrix.getRowsCount()) {
            throw new IllegalArgumentException("Размер матриц должен быть одинаковым.");
        }
        for (int i = 0; i < getRowsCount(); i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    public void deduction(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() || getRowsCount() != matrix.getRowsCount()) {
            throw new IllegalArgumentException("Размер матриц должен быть одинаковым.");
        }
        for (int i = 0; i < getRowsCount(); i++) {
            rows[i].deduction(matrix.rows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Размер матриц должен быть одинаковым.");
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.add(matrix2);
        return matrix1Copy;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Размер матриц должен быть одинаковым.");
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.deduction(matrix2);
        return matrix1Copy;
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно совпадать с количеством строк второй матрицы.");
        }
        int length = matrix2.getRowsCount();
        for (int i = 0; i < length; i++) {
            Vector tmp = new Vector(length);
            for (int j = 0; j < matrix1.getColumnsCount(); j++) {
                tmp.setComponent(Vector.getScalarProduct(matrix1.getRow(i), matrix2.getColumn(j)), j);
            }
            matrix1.rows[i] = tmp;
        }
        return new Matrix(matrix1);
    }
}



