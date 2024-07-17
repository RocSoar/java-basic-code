package com.roc.threadCase;

public class MyThread3 extends Thread {
    public MyThread3() {
    }

    public MyThread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(getName() + "---->" + i);
        }
    }
}
