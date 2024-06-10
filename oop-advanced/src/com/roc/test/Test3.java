package com.roc.test;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("参数数量: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("args" + (i + 1) + ": " + args[i]);
        }
    }
}
