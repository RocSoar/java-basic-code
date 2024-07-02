package com.roc.collection;

import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

public class CollectionDemo {
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//
//        list.add("aaa");
//        list.add("bbb");
//        list.add("ccc");
//        list.add("ddd");
//
//        ListIterator<String> it = list.listIterator();
//
//        while (it.hasNext()) {
//            String s = it.next();
//            if (s.equals("bbb")) {
//                it.add("QQQ");
//            }
//            System.out.println(s);
//        }
//        System.out.println(list);
//        System.out.println(32 >> 1);
//        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
//        list.remove(2);
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);

        Map.Entry[] arr = new Map.Entry[6];
        Map.Entry[] array = map.entrySet().toArray(arr);
        Map<String, Integer> m = Map.ofEntries(map.entrySet().toArray(new Map.Entry[0]));
//        for (Map.Entry entry : arr) {
//            System.out.println(entry);
//        }
//        System.out.println(arr == array);
        Map<String, Integer> map1 = Map.copyOf(m);

        map1.entrySet().forEach(e -> System.out.println(e));
        System.out.println(map1 == m);
    }
}
