package com.roc.test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> foo = Arrays.asList("a", "bb", "ccc", "dd", "e");
        List<Integer> bar = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> aaa = foo.stream().map(String::length).toList();
        var bbb = bar.stream().filter(e -> e % 2 == 0).toList();
        int ccc = bar.stream().reduce((acc, e) -> acc + e).orElse(0);
        String m = foo.stream().filter(e -> e.length() == 3).findFirst().orElseGet(() -> "空");
        System.out.println(m);

    }

    public void test() {
        System.out.println(111);
    }
}
