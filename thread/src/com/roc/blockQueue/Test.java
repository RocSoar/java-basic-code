package com.roc.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(1);
        Thread t1 = new Thread(new Consumer(bq));
        Thread t2 = new Thread(new Producer(bq));

        t1.start();
        t2.start();
    }
}
