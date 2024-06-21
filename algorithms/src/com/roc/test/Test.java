package com.roc.test;

import com.roc.sort.bubbleSort.BubbleSort;
import com.roc.sort.insertSort.InsertSort;
import com.roc.sort.selectionSort.SelectionSort;

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

        long t5 = System.currentTimeMillis();
        int[] insertSorted = InsertSort.insertSort(arr);
        long t6 = System.currentTimeMillis();

        System.out.println(Arrays.equals(bubbleSorted, selectionSorted));
        System.out.println(Arrays.equals(bubbleSorted, insertSorted));
        System.out.println("冒泡排序用时: " + (t2 - t1) + "ms"); // 1671ms
        System.out.println("选择排序用时: " + (t4 - t3) + "ms"); // 2799ms
        System.out.println("插入排序用时: " + (t6 - t5) + "ms"); // 222ms
    }
}
