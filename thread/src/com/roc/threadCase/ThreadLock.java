package com.roc.threadCase;

public class ThreadLock extends Thread {
    static int count = 0;
    static final Object lock = new Object();

    public ThreadLock() {
    }

    public ThreadLock(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (count >= 100)
                    break;
                System.out.println(getName() + "---->" + count++);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
