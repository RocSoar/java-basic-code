package com.roc.test2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(Map.of(
                "张全蛋儿", "农家乐,野外拓展",
                "李二狗子", "轰趴,野外拓展,健身房",
                "翠花", "野外拓展",
                "小帅", "轰趴,健身房",
                "有容", "农家乐"
        ));

        Map<String, Integer> stats = new HashMap<>();

        map.forEach((k, v) -> Arrays.stream(v.split(",")).forEach(s -> stats.merge(s, 1, (o, n) -> o + n)));

        stats.forEach((k, v) -> System.out.println(k + " ---> " + v + "人"));

        System.out.println("-------------------------");
        Map.Entry<String, Integer> entry = stats.entrySet().stream().max((a, b) -> a.getValue() - b.getValue()).get();
        System.out.println("投票最多的去处是: " + entry.getKey() + " ---> " + entry.getValue() + "人");

        System.out.println("-------------------------");
        String choice = entry.getKey();
        map.entrySet().stream().filter(e ->
                Arrays.stream(e.getValue().split(",")).noneMatch(s -> s.equals(choice))
        ).forEach(e -> System.out.println(e.getKey() + "没有选择" + choice));
    }
}
