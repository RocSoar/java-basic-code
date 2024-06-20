package com.roc.serach.basicSearch;

import java.util.ArrayList;
import java.util.List;

public class BasicSearch {
    public static void main(String[] args) {
        int[] arr = {131, 7, 127, 147, 81, 103, 23, 7, 79};
        int[] ints = basicSearch3(arr, 7);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    private static boolean basicSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return true;
        }
        return false;
    }

    private static int basicSearch2(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return i;
        }
        return -1;
    }

    private static int[] basicSearch3(int[] arr, int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                list.add(i);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
