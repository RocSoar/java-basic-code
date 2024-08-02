package com.roc.test6;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();
        mll.add("a");
        mll.add("b");
        mll.add("c");
        mll.add("d");
        mll.add("e");
        mll.reverse(1, 4);
        mll.forEach(e -> System.out.println(e));
        System.out.println(mll);
//        System.out.println(mll.length());
    }
}
