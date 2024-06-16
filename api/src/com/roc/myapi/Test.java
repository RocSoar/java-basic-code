package com.roc.myapi;

import com.roc.utils.ArrayUtil;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        new MyJFrame();
//        String s = "abc";
//        StringBuilder sb = new StringBuilder("abc");
//
//        System.out.println(s.contentEquals(sb));
//        System.out.println(sb.equals(s));
        Student s = new Student("gpx", 23, "男");
        Student cloned = s.clone();
//        cloned.data[0] = 666;
        ArrayUtil.printArray(s.data);
        ArrayUtil.printArray(cloned.data);
        System.out.println(Arrays.equals(s.data, cloned.data));
    }
}
