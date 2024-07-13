package com.roc.myBlockQueue;

public class Test {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(1);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);
        p.start();
        c.start();
    }
}
