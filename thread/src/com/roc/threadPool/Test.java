package com.roc.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
//        ExecutorService es = Executors.newCachedThreadPool();
//        ExecutorService es2 = Executors.newFixedThreadPool(3);
//        es.submit(new MyRunnable());
//        es.submit(new MyRunnable());
//        es.submit(new MyRunnable());
//        es.submit(new MyRunnable());
//        es.submit(new MyRunnable());
//
//        es.shutdown();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
