package com.roc.practices.prac2;

import java.util.ArrayList;
import java.util.List;

public class Test implements A, B {
    public static void main(String[] args) {
//        Test t = new Test();
//        System.out.println(t.test());
//        System.out.println(E.values());
        MyArrayList<Integer> ml = new MyArrayList<>();
        ml.add(1);
        ml.add(1);
        ml.add(1);
        ml.add(1);
        ml.add(1);
        ml.add(1);
        ml.add(1);
        ml.add(1);
        ml.add(1);
        ml.add(9);
        ml.add(2);
        ml.add(3);
        System.out.println(ml.get(23749));
    }

    @Override
    public String test() {
        return "test";
    }
}
