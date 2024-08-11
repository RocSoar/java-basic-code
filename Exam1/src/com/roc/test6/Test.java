package com.roc.test6;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> mll = new MyLinkedList<>();
        mll.add(1);
        mll.add(2);
        mll.add(3);
        mll.add(4);
        mll.add(5);
        mll.add(6);
        mll.reverse(1, 6);
        mll.forEach(e -> System.out.println(e));
        System.out.println(mll);
//        System.out.println(mll.length());
    }
}
