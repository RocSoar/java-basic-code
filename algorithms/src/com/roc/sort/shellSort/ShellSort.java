package com.roc.sort.shellSort;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {2, 4, 5, 3, 1, 6, 7};
//        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
//        System.out.println(Arrays.equals(shellSort(arr), sorted));

        int[] arr = new int[10000000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }

        long start = System.currentTimeMillis();
        shellSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static int[] shellSort(int[] arr) {
//        加入步长的插入排序
        int[] sorted = arr.clone();

        for (int step = sorted.length / 2; step > 0; step /= 2) {
            for (int i = step; i < sorted.length; i++) {
                int index = i;
                int temp = sorted[i];
                for (; index > 0; index -= step) {
                    if (index - step < 0 || temp >= sorted[index - step])
                        break;
                    sorted[index] = sorted[index - step];
                }
                sorted[index] = temp;
            }
        }
        return sorted;
    }
}
