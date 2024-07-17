package com.roc.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prac6 extends Thread {
    public static List<Integer> pool = new ArrayList<>(List.of(10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700));
    List<Integer> box = new ArrayList<>();

    public Prac6(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Prac6.class) {
                if (pool.isEmpty())
                    break;
                Collections.shuffle(pool);
                box.add(pop());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized (Prac6.class) {
            display();
        }
    }

    private void display() {
        int max = box.stream().max((a, b) -> a - b).get();
        int sum = box.stream().reduce(0, (a, b) -> a + b);
        System.out.println("在此次抽奖过程中, " + getName() + "共产生了" + box.size() + "个奖项. ");
        System.out.print("分别为: ");
        box.forEach(i -> System.out.print(i + ", "));
        System.out.println(" 最高奖项为: " + max + ", 总计额为: " + sum);
    }

    private int pop() {
        return pool.remove(pool.size() - 1);
    }
}
