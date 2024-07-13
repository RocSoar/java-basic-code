package com.roc.myBlockQueue;

public class Producer extends Thread {
    MyQueue<Integer> queue;

    public Producer(MyQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
