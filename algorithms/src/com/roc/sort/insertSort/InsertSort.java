package com.roc.sort.insertSort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1, 6};
        int[] sorted = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.equals(insertSort(arr), sorted));
//        Arrays.stream(sorted).boxed().forEach(System.out::println);
    }

    public static int[] insertSort(int[] arr) {
        int[] sorted = arr.clone();

        int startIndex = -1;
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] > sorted[i + 1]) {
                startIndex = i + 1;
                break;
            }
        }
        if (startIndex == -1)
            return sorted;

        for (int i = startIndex; i < sorted.length; i++) {
            for (int j = i; j > 0; j--) {
                if (sorted[j] >= sorted[j - 1])
                    break;
                int temp = sorted[j];
                sorted[j] = sorted[j - 1];
                sorted[j - 1] = temp;
            }
        }
        return sorted;
    }
}
