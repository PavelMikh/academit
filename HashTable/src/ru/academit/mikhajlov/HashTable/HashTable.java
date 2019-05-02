package ru.academit.mikhajlov.HashTable;

import ru.academit.mihajlov.MyArrayList.MyArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HashTable<T> implements Collection<T> {
    private MyArrayList<T>[] array;

    @SuppressWarnings("ConstantConditions")
    public HashTable(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Размер массива не может принимать отрицательные значения.");
        }
        array = (MyArrayList<T>[]) new Object[capacity];
    }

    public int getCollectionIndex(T element) {
        return Math.abs(element.hashCode() % array.length);
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private class MyIterator implements Iterator<T> {
        int currentIndex = -1;
        int modCount = 0;
        private MyArrayList<T> searchCollection(T element) {
            return array[getCollectionIndex(element)];
        }
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
