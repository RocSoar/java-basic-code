package com.roc.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class Prac7 implements Callable<Integer> {
    public static List<Integer> pool = new ArrayList<>(List.of(10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700));

    @Override
    public Integer call() throws InterruptedException {
        List<Integer> box = new ArrayList<>();
        int max;
        while (true) {
            synchronized (Prac7.class) {
                if (pool.isEmpty())
                    break;
                Collections.shuffle(pool);
                box.add(pop());
            }
//            Thread.sleep(100);
        }
        synchronized (Prac7.class) {
            max = display(box);
        }
        return max;
    }

    private int display(List<Integer> box) {
        int max = box.stream().max((a, b) -> a - b).orElse(0);
        int sum = box.stream().reduce(0, (a, b) -> a + b);
        System.out.println("在此次抽奖过程中, " + Thread.currentThread().getName() + "共产生了" + box.size() + "个奖项. ");
        System.out.print("分别为: ");
        box.forEach(i -> System.out.print(i + ", "));
        System.out.println(" 最高奖项为: " + max + ", 总计额为: " + sum);
        return max;
    }

    private int pop() {
        return pool.remove(pool.size() - 1);
    }
}
