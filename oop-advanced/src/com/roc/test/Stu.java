package com.roc.test;

public class Stu {
    private int age;

    public Stu() {
    }

    public Stu(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println(this);
    }
}
