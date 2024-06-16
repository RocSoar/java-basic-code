package com.roc.myapi;

import com.roc.utils.ArrayUtil;

import java.io.IOException;

public class SystemDemo1 {
    public static void main(String[] args) throws IOException {
//        int[][] arr1 = {{1, 2}, {3, 4}};
//        int[][] arr2 = new int[2][2];
//        int[] arr3 = {1, 2, 3, 4, 5};
//        int[] arr4 = new int[5];
//        System.arraycopy(arr3, 0, arr4, 0, 5);
//
////        arr2[0][1] = 5;
//        arr4[4] = 8;
//        ArrayUtil.printArray(arr3);
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.maxMemory() / 1024 / 1024);
        System.out.println(runtime.totalMemory() / 1024 / 1024);
        System.out.println(runtime.freeMemory() / 1024 / 1024);
        runtime.exec("calc");
        runtime.exec("shutdown -a");
    }
}
