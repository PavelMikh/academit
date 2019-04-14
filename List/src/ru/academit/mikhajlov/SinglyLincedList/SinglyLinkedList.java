package ru.academit.mikhajlov.SinglyLincedList;

import ru.academit.mikhajlov.ListItem.ListItem;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int listSize;

    public SinglyLinkedList() {
    }

    public int getListSize() {
        return listSize;
    }

    public T getHeadValue() {
        return this.head.getData();
    }

    public ListItem<T> itemSearch(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Выход за границы списка. Узла с таким индексом не существует.");
        }
        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        return p;
    }

    public T getData(int index) {
        ListItem<T> item = itemSearch(index);
        return item.getData();
    }

    public T setData(int index, T data) {
        ListItem<T> p = itemSearch(index);
        T content = p.getData();
        p.setData(data);
        return content;
    }

    public T removeItem(int index) {
        ListItem<T> p = itemSearch(index - 1);
        T content = p.getNext().getData();
        p.setNext(p.getNext().getNext());
        listSize--;
        return content;
    }

    public void addHead(T data) {
        head = new ListItem<>(data, head);
        listSize++;
    }

    public void add(int index, T data) {
        if (index == 0) {
            addHead(data);
        } else {
            ListItem<T> prev = itemSearch(index - 1);
            ListItem<T> p = new ListItem<>(data, prev.getNext());
            prev.setNext(p);
        }
        listSize++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < this.listSize - 1; i++) {
            stringBuilder.append(this.getData(i).toString()).append(", ");
        }
        return stringBuilder.append(getData(listSize - 1)).append("]").toString();
    }

    public boolean valueRemove(T data) {
        boolean hasRemove = false;
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(data)) {
                if (p == head) {
                    head = p.getNext();
                } else {
                    if (prev != null) {
                        prev.setNext(p.getNext());
                    }
                }
                hasRemove = true;
                listSize--;
            }
        }
        return hasRemove;
    }

    public T firstItemRemove() {
        T tmp = head.getData();
        head = head.getNext();
        listSize--;
        return tmp;
    }

    public void reverse() {
        ListItem<T> first = head;
        ListItem<T> second = first.getNext();
        ListItem<T> third = second.getNext();

        first.setNext(null);
        second.setNext(first);

        while (third != null) {
            first = second;
            second = third;
            third = third.getNext();
            second.setNext(first);
        }
        head = second;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();
        ListItem<T> item = head;
        ListItem<T> nextItem = item.getNext();
        ListItem<T> itemCopy = new ListItem<>(head.getData(), null);

        while (nextItem != null) {
            if (item == head) {
                listCopy.head = itemCopy;
                listCopy.listSize++;
            }
            ListItem<T> nextItemCopy = new ListItem<>(nextItem.getData(), null);
            itemCopy.setNext(nextItemCopy);
            itemCopy = nextItemCopy;
            listCopy.listSize++;
            item = nextItem;
            nextItem = nextItem.getNext();
        }
        return listCopy;
    }
}

