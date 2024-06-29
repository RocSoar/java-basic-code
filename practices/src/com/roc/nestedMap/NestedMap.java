package com.roc.nestedMap;

import java.util.*;

public class NestedMap {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list1 = new ArrayList<>(Arrays.asList("一", "二", "三", "四"));
        List<String> list2 = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));
        List<String> list3 = new ArrayList<>(Arrays.asList("I", "II", "III", "IV"));
        map.put("chinese", list1);
        map.put("english", list2);
        map.put("roma", list3);

        map.forEach((k, v) -> {
            StringJoiner sj = new StringJoiner(", ", k + " = ", "");
            v.forEach(e -> sj.add(e));
            System.out.println(sj);
        });
    }
}
