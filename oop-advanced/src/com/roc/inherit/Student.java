package com.roc.inherit;

public class Student extends Person {
    String name = "student";

    public Student() {
//        System.out.println("Student的空参构造被调用了");
    }

    public Student(String name) {
        System.out.println("Student的有参构造被调用了");
//        this.name = name;
    }

    public Student(int a) {

    }

    @Override
    public String getName() {
        System.out.println(123);
        return name;
    }


//    @Override
//    public void toPerson() {
//        System.out.println("子类的toPerson");
////        super.toPerson();
//    }
}
