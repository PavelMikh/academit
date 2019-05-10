package ru.academit.mihajlov.MyArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int length;
    private int modCount = 0;

    public MyArrayList() {
        //noinspection unchecked
        items = (T[]) new Object[10];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Вместимость списка должена быть больше нуля.");
        }
        //noinspection unchecked
        items = (T[]) new Object[capacity];
    }

    private void checkIndex(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Выход за границы коллекции. Элемента с таким индексом не существует.");
        }
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
        return indexOf(o) != -1;
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int currentModCount = modCount;

        @Override
        public boolean hasNext() {
            return (currentIndex + 1 < length);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция кончилась.");
            }
            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("За время обхода изменилась коллекция.");
            }
            ++currentIndex;
            return items[currentIndex];
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
        if (a == null) {
            throw new NullPointerException("Передаваемый массив не может быть null.");
        }
        if (a.length < length) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, length, a.getClass());
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, a, 0, length);
        if (a.length > length) {
            a[length] = null;
        }
        return a;
    }

    @Override
    public boolean add(T item) {
        if (length == items.length) {
            increaseCapacity();
        }
        items[length] = item;
        ++length;
        ++modCount;
        return true;
    }

    private void increaseCapacity() {
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
        int oIndex = indexOf(o);
        if (oIndex != -1) {
            remove(oIndex);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object cItem : c) {
            if (!contains(cItem)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("Указанная коллекция не может быть null.");
        }
        if (c.isEmpty()) {
            return false;
        }

        ensureCapacity(length + c.size());
        int index = length;
        for (T cItem : c) {
            items[index] = cItem;
            ++index;
        }
        length += c.size();
        ++modCount;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndex(index);
        if (c == null) {
            throw new NullPointerException("Указанная коллекция не может быть null.");
        }
        if (c.isEmpty()) {
            return false;
        }

        ensureCapacity(length + c.size());
        System.arraycopy(items, index, items, index + c.size(), length - index);
        int i = index;
        for (T cItem : c) {
            items[i] = cItem;
            ++i;
        }
        length += c.size();
        ++modCount;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Указанная коллекция не может быть null.");
        }
        if (c.isEmpty()) {
            return false;
        }
        int tmp = modCount;
        for (Object cItem : c) {
            remove(cItem);
        }
        return modCount != tmp;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Указанная коллекция не может быть null.");
        }

        int tmp = modCount;
        for (int i = 0; i < length; i++) {
            if (!c.contains(items[i])) {
                remove(i);
                i--;
            }
        }
        return modCount != tmp;
    }

    public void trimToSize() {
        if (items.length < length) {
            items = Arrays.copyOf(items, length);
        }
    }

    private void ensureCapacity(int desiredSize) {
        if (desiredSize <= items.length) {
            return;
        }
        items = Arrays.copyOf(items, desiredSize);
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            items[i] = null;
        }
        length = 0;
        ++modCount;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Выход за границы списка.");
        }
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Выход за границы списка.");
        }

        T tmp = items[index];
        items[index] = element;
        return tmp;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        if (items.length == length) {
            increaseCapacity();
        }
        if (index == length) {
            add(element);
        } else {
            System.arraycopy(items, index, items, index + 1, length - index);
            items[index] = element;
            ++length;
            ++modCount;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Выход за границы списка.");
        }

        T tmp = items[index];
        System.arraycopy(items, index + 1, items, index, length - (index + 1));
        --length;
        ++modCount;
        return tmp;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
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
