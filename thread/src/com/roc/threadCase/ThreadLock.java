package com.roc.threadCase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock extends Thread {
    static int count = 0;
    static final Lock LOCK = new ReentrantLock();

    public ThreadLock() {
    }

    public ThreadLock(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
//            synchronized (ThreadLock.class) {
            LOCK.lock();
            if (count >= 100) {
                LOCK.unlock();
                break;
            }
            System.out.println(getName() + "---->" + count++);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LOCK.unlock();
//            }
        }
    }
}
