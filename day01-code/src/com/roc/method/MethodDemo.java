package com.roc.method;

public class MethodDemo {
    public static void main(String[] args) {
        float a = 11.8f;
        double b = 11.8;
        compare(a, b);

    }

    public static void compare(int a, int b) {
        System.out.println("int");
        System.out.println(a == b);
    }

    public static void compare(byte a, byte b) {
        System.out.println("byte");
        System.out.println(a == b);
    }

    public static void compare(short a, short b) {
        System.out.println("short");
        System.out.println(a == b);
    }

    public static void compare(long a, long b) {
        System.out.println("long");
        System.out.println(a == b);
    }

    public static void compare(double a, double b) {
        System.out.println("double");
        System.out.println(a == b);
    }


    public static void sayHello(String word) {
        System.out.println(word);
    }
}
