package com.roc.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test3 {
    public static void main(String[] args) {
        Map<Character, Integer> map = new TreeMap<>();
        "eaababcabcdabcd".chars().forEach(c -> map.merge((char) c, 1, (o, n) -> o + n));
        map.forEach((k, v) -> System.out.print(k + " " + '(' + v + ')' + ' '));
    }
}
