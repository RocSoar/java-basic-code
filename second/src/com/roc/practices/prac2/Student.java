package com.roc.practices.prac2;

public class Student extends Person {
    private String gender;

    public Student(String name, int age) {
        super(name, age);
        gender = "男";
    }

    public void display() {
        System.out.println(getName() + getAge());
    }
}
