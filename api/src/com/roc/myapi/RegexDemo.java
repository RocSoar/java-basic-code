package com.roc.myapi;

public class RegexDemo {
    public static void main(String[] args) {
//        System.out.println("abc".matches("[^A-Z][a-zA-Z][a-z]"));
//        System.out.println("a".matches("[a-dm-p]"));
//        System.out.println("d".matches("[a-z&&[def]]"));
//        System.out.println("哈".matches("."));
        System.out.println("a".matches("\\w*"));

        System.out.println("1234567890123456789a".matches("[1-9][0-9]{5,19}"));
    }
}
