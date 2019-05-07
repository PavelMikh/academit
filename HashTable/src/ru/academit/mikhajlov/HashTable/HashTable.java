package ru.academit.mikhajlov.HashTable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] lists;
    private int length;
    private int modCount;

    public HashTable() {
        //noinspection unchecked
        lists = (ArrayList<T>[]) new ArrayList[20];
    }

    public HashTable(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Размер массива не может принимать отрицательные значения.");
        }
        //noinspection unchecked
        lists = (ArrayList<T>[]) new ArrayList[capacity];
    }

    private int getCollectionIndex(T element) {
        if (element == null) {
            return 0;
        }
        return Math.abs(element.hashCode() % lists.length);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                sb.append("key ")
                        .append(i)
                        .append(": ")
                        .append(lists[i].toString())
                        .append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = 0;
        private int currentModCount = modCount;
        private int currentListElementIndex = -1;
        private int elementsCounter = 0;

        @Override
        public boolean hasNext() {
            return elementsCounter != length;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция кончилась.");
            }
            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("За время обхода изменилась коллекция.");
            }
            if ((lists[currentIndex] != null) && (currentListElementIndex < lists[currentIndex].size() - 1)) {
                ++currentListElementIndex;
            } else {
                ++currentIndex;
                while (lists[currentIndex] == null) {
                    ++currentIndex;
                }
                currentListElementIndex = 0;
            }
            ++elementsCounter;
            return lists[currentIndex].get(currentListElementIndex);
        }
    }

    @Override
    public boolean contains(Object o) {
        //noinspection unchecked,SuspiciousMethodCalls
        return lists[getCollectionIndex((T) o)].indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
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
        int index = getCollectionIndex(t);
        if (lists[index] == null) {
            lists[index] = new ArrayList<>();
        }
        lists[index].add(t);
        ++length;
        ++modCount;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            //noinspection unchecked
            int index = getCollectionIndex((T) o);
            lists[index].remove(o);
            if (lists[index].size() == 0) {
                lists[index] = null;
            }
            --length;
            ++modCount;
            return true;
        }
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
