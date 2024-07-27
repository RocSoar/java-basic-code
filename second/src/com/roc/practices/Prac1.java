package com.roc.practices;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prac1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        九九乘法表
//        for (int i = 1; i <= 9; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j + "x" + i + "=" + (j * i) + "\t");
//            }
//            System.out.println();
//        }

//        打印三角形
//        int n = 10;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n - i; j++) {
//                System.out.print(" ");
//            }
//            for (int k = 1; k <= 2 * i - 1; k++) {
//                System.out.print(k % 2 == 0 ? " " : "*");
//            }
//            System.out.println();
//        }
//    }
        Student s1 = new Student("roc", 25);
        Student s2 = new Student("soar", 26);
        Student s3 = new Student("susan", 28);
        List<Student> list = new ArrayList<>(List.of(s1, s2, s3));
        Map<String, Student> map = new HashMap<>();
        list.forEach(e -> map.put(e.getName(), e));
        StudentInfo si = new StudentInfo(list, map);

        File file = new File("second/data.sav");
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//        oos.writeObject(si);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        StudentInfo o = (StudentInfo) ois.readObject();
        ois.close();
        System.out.println(o.list);
        System.out.println(o.map);
    }
}
