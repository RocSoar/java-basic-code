package com.roc.sort.quickSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {2, 4, 5, 3, 1, 6};
//        int[] sorted = {1, 2, 3, 4, 5, 6};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.equals(arr, sorted));
        int[] arr = new int[10000000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }

        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void quickSort(int[] arr, int start, int end) {
//        递归思想
        if (start >= end)
            return;

        int left = start;
        int right = end;

        while (left != right) {
            while (true) {
                if (left >= right || arr[right] < arr[start])
                    break;
                right--;
            }
            while (true) {
                if (left >= right || arr[left] > arr[start])
                    break;
                left++;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        int temp = arr[start];
        arr[start] = arr[left];
        arr[left] = temp;

        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }
}
