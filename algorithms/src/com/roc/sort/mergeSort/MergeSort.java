package com.roc.sort.mergeSort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {2, 4, 5, 3, 1, 6, 7};
//        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
//        System.out.println(Arrays.equals(split(arr), sorted));
        int[] arr = new int[10000000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }

        long start = System.currentTimeMillis();
        split(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static int[] split(int[] arr) {
//        递归拆分+合并
//        数组分左右
//        左右元素相比较
//        一侧用完放对面
//        递归不停分
//        分完再排序
//        排序结束往上走
//        边走边合并
//        走到头顶出结果
        if (arr.length == 1)
            return arr;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < arr.length; i++) {
            if (i < mid)
                left[i] = arr[i];
            else
                right[i - mid] = arr[i];
        }
        return mergeSort(split(left), split(right));
    }

    private static int[] mergeSort(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (leftIndex >= left.length)
                arr[i] = right[rightIndex++];
            else if (rightIndex >= right.length)
                arr[i] = left[leftIndex++];
            else if (left[leftIndex] < right[rightIndex])
                arr[i] = left[leftIndex++];
            else
                arr[i] = right[rightIndex++];
        }
        return arr;
    }
}
