package com.roc.sort.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1, 6};
        int[] sorted = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.equals(selectionSort(arr), sorted));
//        Arrays.stream(sorted).boxed().forEach(System.out::println);
    }

    public static int[] selectionSort(int[] arr) {
        int[] sorted = arr.clone();
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[i] > sorted[j]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }
}
