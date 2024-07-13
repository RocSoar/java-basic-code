package com.roc.threadCase;

public class DeadLock implements Runnable {
    final Object objA = new Object();
    final Object objB = new Object();

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().getName().equals("线程A")) {
                synchronized (objA) {
                    System.out.println("线程A拿到了A锁, 准备去拿B锁");
                    synchronized (objB) {
                        System.out.println("线程A拿到了B锁, 执行完一轮了");
                    }
                }
            } else if (Thread.currentThread().getName().equals("线程B")) {
                synchronized (objB) {
                    System.out.println("线程B拿到了B锁, 准备去拿A锁");
                    synchronized (objA) {
                        System.out.println("线程B拿到了A锁, 执行完一轮了");
                    }
                }
            }
        }
    }
}
