package com.roc.generics;

public class LiHua extends Cat {
    public LiHua(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.print("狸花猫, 正在吃鱼");
        System.out.println();
    }
}
