package com.roc.test;

import com.roc.sort.bubbleSort.BubbleSort;
import com.roc.sort.insertSort.InsertSort;
import com.roc.sort.mergeSort.MergeSort;
import com.roc.sort.quickSort.QuickSort;
import com.roc.sort.selectionSort.SelectionSort;
import com.roc.sort.shellSort.ShellSort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[50000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(50000);
        }
        long t1 = System.currentTimeMillis();
        int[] bubbleSorted = BubbleSort.bubbleSort(arr);
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        int[] selectionSorted = SelectionSort.selectionSort(arr);
        long t4 = System.currentTimeMillis();

        long t31 = System.currentTimeMillis();
        int[] selection2Sorted2 = SelectionSort.selectionSort2(arr);
        long t41 = System.currentTimeMillis();

        long t5 = System.currentTimeMillis();
        int[] insertSorted = InsertSort.insertSort(arr);
        long t6 = System.currentTimeMillis();

        long t51 = System.currentTimeMillis();
        int[] insertSorted2 = InsertSort.insertSort2(arr);
        long t61 = System.currentTimeMillis();

        long t7 = System.currentTimeMillis();
        int[] shellSorted = ShellSort.shellSort(arr);
        long t8 = System.currentTimeMillis();

        long t9 = System.currentTimeMillis();
        int[] cloned = arr.clone();
        QuickSort.quickSort(cloned, 0, cloned.length - 1);
        long t10 = System.currentTimeMillis();

        long t11 = System.currentTimeMillis();
        int[] mergeSorted = MergeSort.split(arr);
        long t12 = System.currentTimeMillis();

        System.out.println(Arrays.equals(bubbleSorted, selectionSorted));
        System.out.println(Arrays.equals(bubbleSorted, selection2Sorted2));
        System.out.println(Arrays.equals(bubbleSorted, insertSorted));
        System.out.println(Arrays.equals(bubbleSorted, insertSorted2));
        System.out.println(Arrays.equals(bubbleSorted, shellSorted));
        System.out.println(Arrays.equals(bubbleSorted, cloned));
        System.out.println(Arrays.equals(bubbleSorted, mergeSorted));
        System.out.println("冒泡排序用时: " + (t2 - t1) + "ms"); // win:1671ms  mac:1168ms
        System.out.println("选择排序用时: " + (t4 - t3) + "ms"); // win:2799ms  mac:2661ms
        System.out.println("选择排序优化版用时: " + (t41 - t31) + "ms"); // win:592ms  mac:???ms
        System.out.println("插入排序用时: " + (t6 - t5) + "ms"); // win:222ms   mac:299ms
        System.out.println("插入排序优化版用时: " + (t61 - t51) + "ms"); // win:129ms   mac:???ms
        System.out.println("希尔排序用时: " + (t8 - t7) + "ms"); // win:8ms   mac:???ms
        System.out.println("快速排序用时: " + (t10 - t9) + "ms"); // win:7ms   mac:5ms
        System.out.println("归并排序用时: " + (t12 - t11) + "ms"); // win:12ms   mac:???ms
    }
}
