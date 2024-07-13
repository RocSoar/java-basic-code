package com.roc.threadCase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable implements Runnable {
    int count = 0;
    final Lock LOCK = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            LOCK.lock(); //Lock锁
            try {
                if (method2())
                    return;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                LOCK.unlock();
            }
        }
    }

//    //同步方法, 锁的唯一标识符为this
//    public synchronized boolean method() {
//        if (count >= 100)
//            return true;
//        System.out.println(Thread.currentThread().getName() + "---->" + count++);
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return false;
//    }

    public boolean method2() throws InterruptedException {
        if (count >= 100)
            return true;
        System.out.println(Thread.currentThread().getName() + "---->" + count++);
        Thread.sleep(10);
        return false;
    }
}
