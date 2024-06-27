package com.roc.map;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {

//        Map<Integer, String> map = new HashMap<>();
//
//        System.out.println(map.put(1, "aaa"));
//        System.out.println(map.put(2, "bbb"));
//        System.out.println(map.put(3, "ccc"));
//        map.forEach((k, v) -> System.out.println(k + ": " + v));
//
//        Iterator<Integer> it = map.keySet().iterator();
//        while (it.hasNext())
//            System.out.println(map.get(it.next()));
//
//        for (Integer k : map.keySet())
//            System.out.println(map.get(k));
//
//        System.out.println(map.getOrDefault(5, "roc"));
//        System.out.println(map.get(5));
//        List<String> list = new ArrayList<>();
//        list.add("abc");

        String[] arr = {"A", "B", "C", "D"};
        Map<String, Integer> map2 = new HashMap<>();
        Random r = new Random();
        IntStream.range(0, 80).forEach(i -> map2.merge(arr[r.nextInt(arr.length)], 1, (o, n) -> o + n));
        System.out.println(map2);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 800; i++) {
            String s = arr[r.nextInt(arr.length)];
//            map.put(s, map.getOrDefault(s, 0) + 1);
//            map.compute(s, (k, v) -> v == null ? 1 : v + 1);
            map.merge(s, 1, (o, n) -> o + n);
        }
//        int max = map.values().stream().max((a, b) -> a - b).get();
//        System.out.println(map.entrySet().stream().filter(entry -> entry.getValue() == max).findFirst().get().getKey());
        System.out.println(map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).findFirst().get());
        System.out.println(map.entrySet().stream().max((a, b) -> a.getValue() - b.getValue()).get());

//        System.out.println(max);
        System.out.println(map);
//        map.compute()
//        String s = "hello-    world";
//        String[] strings = s.split("-\s+");
//        System.out.println(String.join("*", strings));
    }
}
