package com.roc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo2 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(List.of("张无忌", "周芷若", "赵敏", "张强", "张三丰"));
//
//        Stream.of("张无忌", "周芷若", "赵敏", "张强", "张三丰").filter(s -> s.startsWith("张") && s.length() == 3).forEach(s -> System.out.println(s));

        int[] arr = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8};
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> lis2 = new ArrayList<>(List.of(5, 6, 7, 8));
        Stream.concat(list.stream(), lis2.stream()).forEach(i -> System.out.println(i));

        Stream.of("张无忌-14", "张强-15", "赵敏-13")
                .mapToInt(s -> Integer.parseInt(s.split("-")[1]))
                .forEach(s -> System.out.println(s));
    }
}
