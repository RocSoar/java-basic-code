package com.roc.inherit;

public class Person {
    public Person() {
        System.out.println("Person的空参构造被调用了");
    }

    public void toPerson() {
        System.out.println("父类的toPerson");
    }
}
