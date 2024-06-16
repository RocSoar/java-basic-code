package com.roc.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumUtil {
    public static void main(String[] args) {
//        List<Integer> foo = Arrays.asList(1, 3, 5, 4, 2);
//        Collections.reverse(foo);
//        Integer i = Integer.valueOf(1);
//        int i1 = i.intValue();
        IntStream.range(100, 1000000000).filter(NumUtil::isSelfPower).forEach(System.out::println);
//        153
//        370
//        371
//        407
//        1634
//        8208
//        9474
//        54748
//        92727
//        93084
//        548834
//        1741725
//        4210818
//        9800817
//        9926315
//        24678050
//        24678051
//        88593477
//        146511208
//        472335975
//        534494836
//        912985153
    }

    public static List<Integer> separateToList(int num) {
        List<Integer> list = new ArrayList<>();
        for (; num > 0; num /= 10)
            list.add(num % 10);
        Collections.reverse(list);
        return list;
    }

    public static int getNumLength(int num) {
//        int len = 0;
//        for (; num > 0; num /= 10)
//            len++;
        return (num + "").length();
    }

    public static boolean isSelfPower(int num) {
        return separateToList(num).stream().
                reduce(0, (a, b) -> a + (int) Math.pow(b, getNumLength(num))) == num;
    }
}
