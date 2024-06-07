package com.roc.stringdemo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(MyUtils.arrayToString(arr));
//        System.out.println(MyUtils.stringReverser("rocsoar"));

       /* char[] a = {'g', 'p', 'x'};
        String[] b = {"g", "p", "x"};


        String foo = new String(a);
        System.out.println(String.join("-", b));*/

//        CapitalConverter cc = new CapitalConverter();
//        cc.run();
        /*StringBuilder sb = new StringBuilder();
        sb.append(1).append(2).append(3).append(4).append(5);


        StringJoiner sj = new StringJoiner(", ", "[", "]");
        StringJoiner sj2 = new StringJoiner(". ", "<", ">");
        sj.add(1 + "").add(2 + "").add(3 + "").add(4 + "");
        sj2.add("a").add("b").add("c");
        sj.merge(sj2);
        System.out.println(sj);*/
//        StringBuilder sb = new StringBuilder();
//        sb.append("abcdefghijklmnopqrstuvwxyz");
//        sb.append(456789);
//        System.out.println(sb.capacity());
//        System.out.println(sb.length());
//        System.out.println('9' - 48);
//        String foo = "abcdeabcde";
//        foo.toCharArray();
//        System.out.println(foo.contains("deabe"));
        var foo = (char) (57);
        System.out.println(' ' == 32);
    }

    public static String rotate(String str) {
        return str.substring(1) + str.charAt(0);
    }

    public static String rotate2(String str) {
        char[] chs = str.toCharArray();
        char first = chs[0];
        for (int i = 1; i < chs.length; i++) {
            chs[i - 1] = chs[i];
        }

        chs[chs.length - 1] = first;

        return new String(chs);
    }

}
