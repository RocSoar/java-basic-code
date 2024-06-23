package com.roc.arrayAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ArrayAPI {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.binarySearch(arr, 0));
//        int[] copied = Arrays.copyOf(arr, 10);
//        System.out.println(Arrays.toString(copied));
        Integer[] arr = {6, 1, 4, 7, 2, 5, 3};
        Arrays.sort(arr, (o1, o2) -> o1 - o2);
    }
}
