package com.roc.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        /*Scanner sc = new Scanner(System.in);
        Car[] arr = new Car[3];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入品牌, 价格, 颜色, 用空格分隔");
            arr[i] = new Car(sc.next(), sc.nextInt(), sc.next());
        }

        for (Car car : arr) {
            System.out.println("品牌: " + car.getBrand() + " 价格: " + car.getPrice() + " 颜色: " + car.getColor());
        }*/

        StudentManager sm = new StudentManager(3);
        Student s1 = new Student(1, "张三", 22);
        Student s2 = new Student(2, "李四", 24);
        Student s3 = new Student(3, "王五", 25);
        Student s4 = new Student(666, "roc", 28);
        Student s5 = new Student(666, "gpx", 29);

        sm.add(s1);
        sm.add(s2);
        sm.add(s3);
        sm.add(s4);
//        sm.add(s5);
        Student s6 = new Student(888, "gpx", 26);
        sm.update(666, s6);
        sm.printAll();
    }
}
