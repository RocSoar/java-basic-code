package com.roc.threadCase;

public class MyRunnable implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            if (method())
                break;
        }
    }

    //同步方法
    public synchronized boolean method() {
        if (count >= 100)
            return true;
        System.out.println(Thread.currentThread().getName() + "---->" + count++);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
