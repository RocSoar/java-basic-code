package com.roc.hashcode;

import java.util.Arrays;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int yuWen;
    private int math;
    private int english;
    private int[] arr;

    public Student(String name, int age, int yuWen, int math, int english) {
        this.name = name;
        this.age = age;
        this.yuWen = yuWen;
        this.math = math;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSum() {
        return yuWen + math + english;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return age == student.age && Objects.equals(name, student.name) && Objects.deepEquals(arr, student.arr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, Arrays.hashCode(arr));
    }

    @Override
    public int compareTo(Student o) {
        int res = o.getSum() - getSum();
        res = res == 0 ? o.yuWen - yuWen : res;
        res = res == 0 ? o.math - math : res;
        res = res == 0 ? o.english - english : res;
        res = res == 0 ? o.age - age : res;
        res = res == 0 ? o.name.compareTo(name) : res;
        return res;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", yuWen=" + yuWen +
                ", math=" + math +
                ", english=" + english +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
