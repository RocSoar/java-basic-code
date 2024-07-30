package com.roc.test4;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    private int index;
    private int size = 10;
    private Object[] data;

    public MyArrayList() {
        data = new Object[size];
    }

    public void add(T e) {
        if (index >= size)
            grow();
        data[index++] = e;
    }

    public T get(int index) {
        if (index < 0 || index >= this.index)
            return null;
        return (T) data[index];
    }

    public boolean set(int index, T e) {
        if (index < 0 || index >= this.index)
            return false;
        data[index] = e;
        return true;
    }

    public boolean set(T oldValue, T newValue) {
        int index = indexOf(oldValue);
        if (index == -1)
            return false;
        return set(index, newValue);
    }

    public int indexOf(T e) {
        for (int i = 0; i < data.length; i++) {
            if (Objects.equals(e, data[i]))
                return i;
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index >= this.index)
            return null;

        Object e = data[index];
        Object[] newArr = new Object[size];
        for (int i = 0; i < data.length - 1; i++) {
            if (i < index)
                newArr[i] = data[i];
            else
                newArr[i] = data[i + 1];
        }
        this.index--;
        data = newArr;
        return (T) e;
    }

    public boolean remove(T e) {
        int index = indexOf(e);
        if (index == -1)
            return false;
        remove(index);
        return true;
    }

    public int length() {
        return index;
    }

    public int capacity() {
        return size;
    }

    private void grow() {
        size = size + size / 2;
        data = Arrays.copyOf(data, size);
    }

    public void forEach(Consumer<T> action) {
        for (int i = 0; i < index; i++)
            action.accept((T) data[i]);
    }
}

@FunctionalInterface
interface Consumer<K> {
    void accept(K e);
}
