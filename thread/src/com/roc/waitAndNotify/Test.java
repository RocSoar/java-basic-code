package com.roc.waitAndNotify;

public class Test {
    public static void main(String[] args) {
        Cook c = new Cook("生产者");
        Foodie f = new Foodie("消费者");
        c.start();
        f.start();
    }
}
