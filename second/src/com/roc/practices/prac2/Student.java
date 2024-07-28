package com.roc.practices.prac2;

import java.util.Objects;

public class Student extends Person {
    private String gender;
    private double height;

    public Student(String name, int age) {
        super(name, age);
        gender = "男";
    }

    public void display() {
        System.out.println(getName() + getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Double.compare(height, student.height) == 0 && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, height);
    }
}
