package com.roc.sort.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1, 6};
        int[] sorted = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.equals(selectionSort2(arr), sorted));
//        Arrays.stream(sorted).boxed().forEach(System.out::println);
    }

    public static int[] selectionSort(int[] arr) {
//       最小的依次放左边 大量的交换元素 速度很慢
        int[] sorted = arr.clone();
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j] < sorted[i]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }

    public static int[] selectionSort2(int[] arr) {
//        缓存索引而不是每次都交换 速度较快
        int[] sorted = arr.clone();
        for (int i = 0; i < sorted.length - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j] < sorted[indexMin])
                    indexMin = j;
            }
            int temp = sorted[i];
            sorted[i] = sorted[indexMin];
            sorted[indexMin] = temp;
        }
        return sorted;
    }
}
