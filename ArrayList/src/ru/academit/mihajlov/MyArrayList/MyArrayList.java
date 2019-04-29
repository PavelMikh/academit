package ru.academit.mihajlov.MyArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int length;
    private int modCount = 0;

    @SuppressWarnings("uncheced")
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость списка не может принимать отрицательное значение.");
        }
        items = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (T item : items) {
            if (Objects.equals(item, o)) {
                return true;
            }
        }
        return false;
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;
        int currentModCount = modCount;

        @Override
        public boolean hasNext() {
            return (currentIndex + 1 < length);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция кончилась.");
            }
            if (currentModCount < modCount) {
                throw new ConcurrentModificationException("За время обхода изменилась коллекция.");
            }
            ++currentIndex;
            return items[currentIndex];
        }

        @Override
        public void remove() {
            if ((currentIndex + 1) < size()) {
                System.arraycopy(items, currentIndex + 1, items, currentIndex, size() - (currentIndex - 1));
            }
            --length;
            ++modCount;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, length);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < length) {
            return (T1[]) toArray();
        }
        System.arraycopy(items, 0, a, 0, length);
        if (a.length > length) {
            a[length] = null;
        }
        return a;
    }

    @Override
    public boolean add(T item) {
        if (length == items.length) {
            doublingCapacity();
        }
        items[length] = item;
        ++length;
        ++modCount;
        return true;
    }

    public void increaseCapacity(Collection<?> c) {
        items = Arrays.copyOf(items, items.length + c.size());
    }

    private void doublingCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                stringBuilder.append(items[i]);
            } else {
                stringBuilder.append(items[i]).append(", ");
            }
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public boolean remove(Object o) {
        Iterator iterator = iterator();
        for (; iterator().hasNext(); ) {
            if (Objects.equals(iterator.next(), o)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean isContain = false;
        int coincidencesCount = 0;
        for (Object cItem : c) {
            for (T item : items) {
                if (cItem == item) {
                    isContain = true;
                    ++coincidencesCount;
                }
            }
            if (!isContain) {
                return false;
            }
        }
        return coincidencesCount == c.size();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (T cItem : c) {
            add(cItem);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Выход за границы списка.");
        }
        ++modCount;
        if (c.isEmpty()) {
            return false;
        }
        if (items.length - length < c.size()) {
            increaseCapacity(c);
        }
        System.arraycopy(items, index, items, index + c.size(), length - index);
        int i = index;
        for (T cItem : c) {
            items[i] = cItem;
            ++i;
        }
        length += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        modCount++;
        if (c.isEmpty()) {
            return false;
        }
        for (Object cItem : c) {
            for (Object item : items) {
                if (cItem == item) {
                    remove(item);
                }
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
