package com.roc.utils;

public class ArrayUtil {
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else {
                System.out.print(", " + arr[i]);
            }
        }
        System.out.print("]\n");
        System.out.println("length: " + arr.length);
    }

    public static void printArray(int[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0)
                    System.out.print(arr[i][j]);
                else
                    System.out.print(", " + arr[i][j]);
            }
            if (i == arr.length - 1)
                System.out.println("]");
            else
                System.out.println("],");
        }
        System.out.println("]");
    }
}
