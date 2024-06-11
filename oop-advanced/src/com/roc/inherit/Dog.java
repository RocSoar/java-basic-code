package com.roc.inherit;

public class Dog extends Animal {

    public Dog(int age, String color) {
        super(age, color);
    }

    public void lookHome() {
        System.out.println("正在看家");
    }

    @Override
    public void eat(String sth) {
        super.eat(sth);
        System.out.println("狗两只前腿死死的抱住" + sth + "猛吃");
    }
}
