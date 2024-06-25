package com.roc.generics;

public class Husky extends Dog {
    public Husky(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.print("哈士奇, 正在吃骨头, 边吃便拆家");
        System.out.println();
    }
}
