package com.roc.myBlockQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    private int length = 0;

    public MyQueue(int length) {
        this.length = length;
    }

    public synchronized void put(T value) throws InterruptedException {
        while (queue.size() == length)
            this.wait();

        queue.add(value);
        this.notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.isEmpty())
            this.wait();

        T value = queue.poll();
        this.notifyAll();
        return value;
    }
}
