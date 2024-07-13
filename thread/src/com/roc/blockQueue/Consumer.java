package com.roc.blockQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Integer value = queue.take();
                System.out.println("Consumed ---> " + value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
