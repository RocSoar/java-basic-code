package com.roc.test;

public class Test1 {
    public static void main(String[] args) {
        printPrime(101, 200);
    }

    public static boolean isPrime(int num) {
        if (num < 1)
            return false;
        if (num == 1)
            return true;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    public static void printPrime(int from, int to) {
        int count = 0;
        for (int i = from; i <= to; i++) {
            if (isPrime(i)) {
                System.out.println(i + "是质数");
                count++;
            }
        }
        System.out.println("一共有" + count + "个质数");
    }
}
