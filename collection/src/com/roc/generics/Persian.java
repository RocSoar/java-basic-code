package com.roc.generics;

public class Persian extends Cat {
    public Persian(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.print("波斯猫, 正在吃小饼干");
        System.out.println();
    }
}
