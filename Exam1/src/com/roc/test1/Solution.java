package com.roc.test1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 1; i <= 100; i++) {
            Student s = new Student(r.nextInt(1, 201), i);
            if (list.contains(s)) {
                i--;
                continue;
            }
            list.add(s);
        }
        System.out.println(removeOdd(list));
    }

    public static Student removeOdd(List<Student> list) {
        if (list.size() == 1)
            return list.get(0);

        List<Student> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((i + 1) % 2 == 0)
                res.add(list.get(i));
        }
        return removeOdd(res);
    }
}
