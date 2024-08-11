package com.roc.practice;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Prac1 {
    public static void main(String[] args) {
        AtomicInteger gifts = new AtomicInteger(100);
        Lock lock = new ReentrantLock();

        Runnable r1 = () -> {
            int count = 1;
            while (true) {
                lock.lock();
                try {
                    if (gifts.get() < 10)
                        break;
                    System.out.println("小明送出了第" + (count++) + "份礼物");
                    gifts.getAndDecrement();
                } finally {
                    lock.unlock();
                }
            }
        };
        Runnable r2 = () -> {
            int count = 1;
            while (true) {
                lock.lock();
                try {
                    if (gifts.get() < 10)
                        break;
                    System.out.println("小红送出了第" + (count++) + "份礼物");
                    gifts.getAndDecrement();
                } finally {
                    lock.unlock();
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
