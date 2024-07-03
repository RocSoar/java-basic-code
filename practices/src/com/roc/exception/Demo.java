package com.roc.exception;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        try {
            System.out.println(arr[10]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
