package com.roc.test;

public class Student {
    public String name;

    public Student() {
        System.out.println("空参构造");
    }

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
