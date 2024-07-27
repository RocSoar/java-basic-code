package com.roc.practices.prac2;

public class MyArrayList<T> {
    private final Object[] arr;
    private int size = 10;
    private int i = 0;

    public MyArrayList() {
        arr = new Object[size];
    }

    public void add(T e) {
        arr[i++] = e;
        i = i % size;
    }

    public T get(int index) {
        return (T) arr[index % size];
    }
}
