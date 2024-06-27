package com.roc.map;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map.put("roc", 1);
        map2.put("gpx", 2);
        map2.put("roc", 3);

        map.putAll(map2);

        System.out.println(map);
    }
}
