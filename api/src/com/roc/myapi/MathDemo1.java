package com.roc.myapi;

import java.util.ArrayList;
import java.util.List;

public class MathDemo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            if (isPrime2(i))
                list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时: " + (end - start) + "ms");
//        isPrime1用时: 14067ms
//        isPrime2用时: 43ms
    }

    public static boolean isPrime1(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrime2(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
