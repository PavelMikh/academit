package ru.academit.mikhajlov.SinglyLincedList;

import ru.academit.mikhajlov.ListItem.ListItem;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public T getHeadValue() {
        if (isEmpty()) {
            throw new NullPointerException("Список пуст.");
        }
        return this.head.getData();
    }

    private ListItem<T> findItem(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Выход за границы списка. Узла с таким индексом не существует.");
        }
        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        return p;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getData(int index) {
        ListItem<T> item = findItem(index);
        return item.getData();
    }

    public T setData(int index, T data) {
        ListItem<T> p = findItem(index);
        T content = p.getData();
        p.setData(data);
        return content;
    }

    public T removeItem(int index) {
        if (index == 0) {
            T content = getHeadValue();
            head = head.getNext();
            size--;
            return content;
        }
        ListItem<T> prev = findItem(index - 1);
        ListItem<T> p = prev.getNext();
        prev.setNext(p.getNext());
        size--;
        return p.getData();
    }

    public void addHead(T data) {
        head = new ListItem<>(data, head);
        size++;
    }

    public void add(int index, T data) {
        if (index == 0) {
            addHead(data);
        } else {
            ListItem<T> prev = findItem(index - 1);
            ListItem<T> p = new ListItem<>(data, prev.getNext());
            prev.setNext(p);
            size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (p.getNext() == null) {
                stringBuilder.append(p.getData());
            } else {
                stringBuilder.append(p.getData()).append(", ");
            }
        }
        return stringBuilder.append("]").toString();
    }

    public boolean deleteByValue(T data) {
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (Objects.equals(p.getData(), data)) {
                if (prev == null) {
                    head = p.getNext();
                } else {
                    prev.setNext(p.getNext());
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public T removeHead() {
        if (isEmpty()) {
            throw new NullPointerException("Список пуст.");
        }
        T tmp = head.getData();
        head = head.getNext();
        size--;
        return tmp;
    }

    public void reverse() {
        if (size <= 1) {
            return;
        }
        ListItem<T> prev = head;
        ListItem<T> current = prev.getNext();
        ListItem<T> next = current.getNext();

        prev.setNext(null);
        current.setNext(prev);

        while (next != null) {
            prev = current;
            current = next;
            next = next.getNext();
            current.setNext(prev);
        }
        head = current;
    }

    public SinglyLinkedList<T> copy() {
        if (size == 0) {
            return new SinglyLinkedList<>();
        }
        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();
        listCopy.size = size;
        ListItem<T> item = head;
        ListItem<T> nextItem = item.getNext();
        ListItem<T> itemCopy = new ListItem<>(head.getData(), null);
        listCopy.head = itemCopy;

        while (nextItem != null) {
            ListItem<T> nextItemCopy = new ListItem<>(nextItem.getData(), null);
            itemCopy.setNext(nextItemCopy);
            itemCopy = nextItemCopy;
            nextItem = nextItem.getNext();
        }
        return listCopy;
    }
}

