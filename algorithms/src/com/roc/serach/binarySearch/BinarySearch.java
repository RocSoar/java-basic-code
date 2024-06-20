package com.roc.serach.binarySearch;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {131, 7, 127, 147, 81, 103, 23, 7, 79};
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
//        [7, 7, 23, 79, 81, 103, 127, 131, 147]
        Random r = new Random();
        int[] bigArr = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            bigArr[i] = r.nextInt(10000000);
        }
        sortedArr = Arrays.stream(bigArr).sorted().toArray();
        System.out.println(binarySearch(sortedArr, 23));
        System.out.println(binarySearch2(sortedArr, 23));
        System.out.println(binarySearch3(sortedArr, 23));
    }

    private static int binarySearch(int[] sortedArr, int num) {
//        二分查找
        int min = 0;
        int max = sortedArr.length - 1;
        int count = 0;
        while (true) {
            if (min > max)
                return -1;

            count++;
            int mid = (min + max) / 2;
            int n = sortedArr[mid];
            if (n == num) {
                System.out.println("二分查找次数为: " + count);
                return mid;
            } else if (n > num)
                max = mid - 1;
            else
                min = mid + 1;
        }
    }

    private static int binarySearch2(int[] sortedArr, int num) {
//        插值查找
        int min = 0;
        int max = sortedArr.length - 1;
        int count = 0;
        while (true) {
            if (min > max)
                return -1;

            count++;
            int mid = min + (max - min) * (num - sortedArr[min]) / (sortedArr[max] - sortedArr[min]);
            int n = sortedArr[mid];
            if (n == num) {
                System.out.println("插值查找次数为: " + count);
                return mid;
            } else if (n > num)
                max = mid - 1;
            else
                min = mid + 1;
        }
    }

    private static int binarySearch3(int[] sortedArr, int num) {
//        斐波那契查找
        int min = 0;
        int max = sortedArr.length - 1;
        int count = 0;
        while (true) {
            if (min > max)
                return -1;

            count++;
            int mid = min + (int) Math.round((max - min) * 0.618) - 1;
            int n = sortedArr[mid];
            if (n == num) {
                System.out.println("斐波那契查找次数为: " + count);
                return mid;
            } else if (n > num)
                max = mid - 1;
            else
                min = mid + 1;
        }
    }
}
