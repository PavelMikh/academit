package ru.academit.mihajlov.MyArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int length;
    private int modCount = 0;

    public MyArrayList() {
        items = (T[]) new Object[10];
    }

    @SuppressWarnings("uncheced")
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость списка не может принимать отрицательное значение.");
        }
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
        ensureCapacity(length + c.size());
        for (T cItem : c) {
            add(cItem);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndex(index);
        ensureCapacity(length + c.size());
        if (c.isEmpty()) {
            return false;
        }
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
        ++modCount;
        trimToSize();
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.isEmpty()) {
            return false;
        }
        Object[] elements = new Object[c.size()];
        boolean isContain = false;
        int coincidencesCount = 0;
        for (Object cItem : c) {
            for (Object item : items) {
                if (item == cItem) {
                    elements[coincidencesCount] = cItem;
                    ++coincidencesCount;
                    ++modCount;
                }
            }
            if (coincidencesCount > 0) {
                isContain = true;
            }
            if (!isContain) {
                return false;
            }
        }
        items = (T[]) Arrays.copyOf(elements, items.length);
        length = coincidencesCount;
        trimToSize();
        return true;
    }

    public void trimToSize() {
        items = Arrays.copyOf(items, length);
    }

    public void ensureCapacity(int desiredSize) {
        if (desiredSize <= items.length) {
            return;
        }
        items = Arrays.copyOf(items, desiredSize);
    }

    @Override
    public void clear() {
        length = 0;
        trimToSize();
        ++modCount;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        return items[index] = element;
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

        }
        ++modCount;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T tmp = items[index];
        System.arraycopy(items, index + 1, items, index, length - (index + 1));
        --length;
        ++modCount;
        return tmp;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Object item : items) {
            if (item == o) {
                return index;
            }
            ++index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int tmp = -1;
        for (Object item : items) {
            if (item == o) {
                tmp = index;
            }
            ++index;
        }
        return tmp;
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
