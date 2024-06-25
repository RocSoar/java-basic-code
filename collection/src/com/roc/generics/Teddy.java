package com.roc.generics;

public class Teddy extends Dog {
    public Teddy(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.print("泰迪, 正在吃骨头, 边吃边蹭");
        System.out.println();
    }
}
