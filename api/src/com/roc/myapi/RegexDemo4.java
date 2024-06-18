package com.roc.myapi;

public class RegexDemo4 {
    public static void main(String[] args) {
//        String str = "roc123gpx456soar";
//
//        String s = str.replaceAll("\\d+", ",");
//        String[] split = str.split("\\d+");
//        System.out.println(s);
//
//        for (String string : split) {
//            System.out.println(string);
//        }
        String str = "aaa123aaa";
        String str2 = "&&abc&";

        System.out.println(str.matches("((.)\\2+).*\\1"));
        System.out.println(str2.matches("(.)\\1*.*\\1"));
    }
}
