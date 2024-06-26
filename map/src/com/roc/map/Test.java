package com.roc.map;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        System.out.println(map.put(1, "aaa"));
        System.out.println(map.put(2, "bbb"));
        System.out.println(map.put(3, "ccc"));
        map.forEach((k, v) -> System.out.println(k + ": " + v));

        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext())
            System.out.println(map.get(it.next()));

        for (Integer k : map.keySet())
            System.out.println(map.get(k));

        System.out.println(map.getOrDefault(5, "roc"));
        System.out.println(map.get(5));
        List<String> list = new ArrayList<>();
        list.add("abc");
    }
}
