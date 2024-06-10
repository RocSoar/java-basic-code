package com.roc.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static List<Integer> foo;

    static {
        foo = new ArrayList<>();
        foo.add(1);
        foo.add(2);
        foo.add(3);
        foo.add(4);
        foo.add(5);
    }

    public static void main(String[] args) {
    }

    public void display() {
        System.out.println(foo);
    }
}
