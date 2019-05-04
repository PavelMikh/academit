package ru.academit.mikhajlov.HashTable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] lists;
    private int size;
    private int modCount;

    public HashTable() {
        lists = (ArrayList<T>[]) new ArrayList[20];
    }

    public HashTable(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Размер массива не может принимать отрицательные значения.");
        }
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
        return lists.length;
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
        int currentIndex = 0;
        int currentModCount = modCount;
        int currentListElementIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex < lists.length;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция кончилась.");
            }
            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("За время обхода изменилась коллекция.");
            }
            if (currentListElementIndex < lists[currentIndex].size() - 1) {
                ++currentListElementIndex;
            } else {
                if (currentIndex < lists.length - 1) {
                    ++currentIndex;
                }
                while (lists[currentIndex] == null && currentIndex < lists.length - 1) {
                    ++currentIndex;
                }
                currentListElementIndex = 0;
            }

            return lists[currentIndex].get(currentListElementIndex);
        }
    }

    @Override
    public boolean contains(Object o) {
        return false;
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
        ++size;
        ++modCount;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        while (iterator().hasNext()) {
            if (Objects.equals(o, iterator().next())) {
//                TODO
            }
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
