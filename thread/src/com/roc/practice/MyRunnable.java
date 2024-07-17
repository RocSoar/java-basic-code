package com.roc.practice;

public class MyRunnable implements Runnable {
    public static int count = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (MyRunnable.class) {
                if (count > 100)
                    break;
                if (count % 2 != 0)
                    System.out.println(Thread.currentThread().getName() + "--->" + count);
                count++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
