package com.roc.practice;

public class MyThread extends Thread {
    public static int count;

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (count >= 1000)
                    break;
                System.out.println(getName() + "卖了第" + ++count + "张票");
                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
