package com.roc.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<T> {
    private final Object[] obj = new Object[10];
    private int size;

    public MyArrayList() {
    }

    public boolean add(T e) {
        obj[size++] = e;
        return true;
    }

    public T get(int index) {
        return (T) obj[index];
    }

    //    ? extends E: 表示可以传递E或者E所有的子类类型
    public void method(MyArrayList<? extends Object> args) {

    }

    //    ? super E: 表示可以传递E或者E所有的父类类型
    public void method2(MyArrayList<? super Object> args) {

    }

    @Override
    public String toString() {
        return Arrays.toString(obj);
    }
}
