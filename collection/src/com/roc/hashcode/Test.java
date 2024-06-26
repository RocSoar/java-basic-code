package com.roc.hashcode;

import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
//        System.out.println("abc".hashCode());
//        System.out.println("acD".hashCode());

//        Student s1 = new Student("abc", 21);
//        Student s2 = new Student("bce", 22);
//        Student s3 = new Student("bcd", 22);
//        Student s4 = new Student("bce", 22);
//
//        Set<Student> ts = new TreeSet<>();
//        System.out.println(ts.add(s2));
//        System.out.println(ts.add(s3));
//        System.out.println(ts.add(s4));
//        System.out.println(ts.add(s1));
//
//        System.out.println(ts);

//        Set<String> ts = new TreeSet<>((o1, o2) -> {
//            int res = o1.length() - o2.length();
//            return res == 0 ? o1.compareTo(o2) : res;
//        });
//
//        ts.add("c");
//        ts.add("qw");
//        ts.add("ab");
//        ts.add("abc");
//
//        System.out.println(ts);

        Student s1 = new Student("abc", 23, 55, 66, 77);
        Student s2 = new Student("bc", 24, 56, 65, 77);
        Student s3 = new Student("qwe", 25, 55, 66, 77);

        Set<Student> ts = new TreeSet<>();

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);

        System.out.println(ts);
    }
}
