package com.roc.map;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        sum(1, 2, 3);
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>();

        Collections.addAll(list2, 4, 5, 6, 7, 8);
//        Collections.addAll(list, 6, 7, 8, 9);
//        list.addAll(list2);
        Collections.shuffle(list);
        Collections.swap(list, 1, 3);
        Collections.max(list);
        Collections.sort(list, (a, b) -> a - b);
        System.out.println(Collections.binarySearch(list, 5));

//        boolean b = list.retainAll(list2);
        System.out.println(list);
    }

    public static void sum(int... params) {
        for (int i = 0; i < params.length; i++) {
            System.out.println(params[i]);
        }
    }
}
