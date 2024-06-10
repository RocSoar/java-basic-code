package com.roc.test;

import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        Stu s1 = new Stu(21);
        Stu s2 = new Stu(22);
        Stu s3 = new Stu(23);
        Stu s4 = new Stu(24);
        List<Stu> foo = Arrays.asList(s1, s2, s3, s4);

//        Stu abc = foo.stream().min((a, b) -> a.getAge() - b.getAge()).get();
//        System.out.println(abc.getAge());
        foo.forEach(s -> s.display());
    }
}
