package com.roc.threadCase;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "---->" + i);
        }
    }
}
