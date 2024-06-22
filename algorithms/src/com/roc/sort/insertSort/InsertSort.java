package com.roc.sort.insertSort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1, 6};
        int[] sorted = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.equals(insertSort2(arr), sorted));
//        Arrays.stream(insertSort2(arr)).boxed().forEach(System.out::println);
    }

    public static int[] insertSort(int[] arr) {
//        版本1 交换元素思想, 速度较慢
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

    public static int[] insertSort2(int[] arr) {
//        版本2 缓存无序区第一个元素,有序区元素往后移位思想, 无交换操作 速度较快
        int[] sorted = arr.clone();

        int startIndex = -1;
//        确定无序区第一个元素索引的位置
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] > sorted[i + 1]) {
                startIndex = i + 1;
                break;
            }
        }
        if (startIndex == -1)
            return sorted;

        for (int i = startIndex; i < sorted.length; i++) {
            int index = i;
            int temp = sorted[i];
            for (; index > 0; index--) {
                if (temp >= sorted[index - 1])
                    break;
                sorted[index] = sorted[index - 1];
            }
            sorted[index] = temp;
        }
        return sorted;
    }
}
