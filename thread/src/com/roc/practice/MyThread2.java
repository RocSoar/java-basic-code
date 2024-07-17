package com.roc.practice;

import java.util.Random;

public class MyThread2 extends Thread {
    public static double amount = 100;
    public static int count = 4;
    public static Random r = new Random();

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (MyThread2.class) {
            count--;
            if (count < 1) {
                System.out.println(Thread.currentThread().getName() + "没抢到");
                return;
            }
            if (count == 1) {
                System.out.printf("%s%s%.2f%n", Thread.currentThread().getName(), "抢到了", amount);
                return;
            }
            double num = r.nextDouble(0.01, amount / (count - 1));
            System.out.printf("%s%s%.2f%n", Thread.currentThread().getName(), "抢到了", num);
            amount -= num;
        }
    }
}
