package com.roc.practices;

public class Prac1 {
    public static void main(String[] args) {
//        九九乘法表
//        for (int i = 1; i <= 9; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j + "x" + i + "=" + (j * i) + "\t");
//            }
//            System.out.println();
//        }

//        打印三角形
        int n = 10;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(k % 2 == 0 ? " " : "*");
            }
            System.out.println();
        }
    }
}
