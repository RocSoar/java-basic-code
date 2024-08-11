package com.roc.test;

import java.util.Objects;

public class Util {
    public static int reverseNumber(int num) {
        int reversedNum = 0;
        while (true) {
            if (num == 0)
                break;
            int ge = num % 10;
            reversedNum = reversedNum * 10 + ge;
            num /= 10;
        }

        return reversedNum;
    }

    public static int concatToNumber(int[] arr) {
        Objects.requireNonNull(arr);
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num * 10 + arr[i];
        }
        return num;
    }

    public static int[] separateToArray(int num) {
        int temp = num;
        int len = 0;
        while (true) {
            if (num == 0)
                break;
            num /= 10;
            len++;
        }
        int[] arr = new int[len];
        for (int i = arr.length - 1; i >= 0; i--, temp /= 10) {
            arr[i] = temp % 10;
        }
        return arr;
    }
}
