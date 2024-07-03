package com.roc.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice1 {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(i -> i % 2 == 0).toList();
        System.out.println(list);

        Map<String, Integer> map = Stream.of("zhangsan, 23", "lisi, 24", "wangwu, 25")
                .filter(s -> Integer.parseInt(s.split(",\\s+")[1]) >= 24)
                .collect(Collectors.toMap(s -> s.split(",\\s+")[0], s -> Integer.parseInt(s.split(",\\s+")[1])));

        System.out.println(map);

        List<String> l1 = new ArrayList<>(List.of("男一,23", "男二二,24", "男三,25", "男四,26", "男五五,27", "男六六,28"));
        List<String> l2 = new ArrayList<>(List.of("杨一,23", "女二,24", "杨三三,25", "女四,26", "杨五,27", "女六,28"));

        Stream<String> stream1 = l1.stream().filter(s -> s.split(",")[0].length() == 3).limit(2);
        Stream<String> stream2 = l2.stream().filter(s -> s.startsWith("杨")).skip(1);

        Actor[] actors = Stream.concat(stream1, stream2).map(Actor::new).toArray(Actor[]::new);
        Arrays.stream(actors).forEach(System.out::println);

        String[] arr = Arrays.stream(actors).map(Actor::getName).toArray(String[]::new);
        System.out.println(Arrays.toString(arr));

        String[] arr2 = Arrays.stream(actors).map(Actor::concat).toArray(String[]::new);
        System.out.println(Arrays.toString(arr2));
    }
}
