package com.roc.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyRunnable2 implements Runnable {
    List<Integer> pool = new ArrayList<>(List.of(10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700));

    @Override
    public void run() {
        while (!draw(pool)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized boolean draw(List<Integer> pool) {
        if (pool.isEmpty())
            return true;
        Collections.shuffle(pool);
        System.out.println(Thread.currentThread().getName() + "又产生了一个" + pop(pool) + "元大奖");
        return false;
    }

    private int pop(List<Integer> pool) {
        return pool.remove(pool.size() - 1);
    }
}
