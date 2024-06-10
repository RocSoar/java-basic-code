package com.roc.inherit;

public class Student extends Person {
    private String name;

    public Student() {
        System.out.println("Student的空参构造被调用了");
    }

    private void toStu() {
    }

    @Override
    public void toPerson() {
//        super.toPerson();
        System.out.println("子类的toPerson");
    }
}
