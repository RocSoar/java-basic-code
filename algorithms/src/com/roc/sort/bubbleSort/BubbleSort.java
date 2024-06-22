package com.roc.sort.bubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1, 6};
        int[] sorted = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.equals(bubbleSort(arr), sorted));
//        Arrays.stream(sorted).boxed().forEach(System.out::println);
    }

    public static int[] bubbleSort(int[] arr) {
//        最大的依次放右边  大量的交换元素 速度很慢
        int[] sorted = arr.clone();
        for (int i = sorted.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }
}
