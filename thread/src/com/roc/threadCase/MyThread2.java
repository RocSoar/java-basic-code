package com.roc.threadCase;

public class MyThread2 extends Thread {
    public MyThread2() {
    }

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + "---->" + i);
        }
    }
}
