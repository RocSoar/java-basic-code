package com.roc.myBlockQueue;

public class Consumer extends Thread {
    MyQueue<Integer> queue;

    public Consumer(MyQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Integer v = queue.take();
                System.out.println("Consumed: " + v);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
