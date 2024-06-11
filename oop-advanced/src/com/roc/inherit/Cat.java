package com.roc.inherit;

public class Cat extends Animal {

    public Cat(int age, String color) {
        super(age, color);
    }

    public void catchMouse() {
        System.out.println("正在抓老鼠");
    }

    @Override
    public void eat(String sth) {
        super.eat(sth);
        System.out.println("猫眯着眼睛侧着头吃" + sth);
    }
}
