package com.roc.recursion;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(sum(100));
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arrSum(arr, arr.length - 1));

        System.out.println(factorial(5));
    }

    public static int sum(int n) {
        if (n == 1)
            return 1;
        return n + sum(n - 1);
    }

    public static int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static int arrSum(int[] arr, int index) {
        if (index == 0)
            return arr[0];
        return arr[index] + arrSum(arr, index - 1);
    }
}
