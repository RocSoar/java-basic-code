package com.roc.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int num = fibonacci(40);
        long t2 = System.currentTimeMillis();
//
        System.out.println(num);
        System.out.println("耗时: " + (t2 - t1));
//        int[] arr = new int[12];
//        for (int i = 1; i <= 12; i++) {
//            arr[i - 1] = fibonacci(i);
//        }
//
//        System.out.println(Arrays.toString(arr));
//        System.out.println(eatPeach(7));
//        System.out.println(climbStair2(20));
    }

    public static int fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int climbStair(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStair(n - 1) + climbStair(n - 2);
    }

    public static int climbStair2(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;
        return climbStair2(n - 1) + climbStair2(n - 2) + climbStair2(n - 3);
    }

    public static int eatPeach(int n) {
        if (n > 10)
            return -1;
        if (n == 10)
            return 1;
        return (eatPeach(n + 1) + 1) * 2;
    }
}
