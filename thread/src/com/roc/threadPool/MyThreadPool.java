package com.roc.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3, //核心线程数量, 不能小于0
                6, //最大线程数量, 不能小于0, 最大数量>=核心线程数量, 空闲线程=最大-核心
                60,//空闲线程最大存货时间,当空闲线程没有任务执行, 超过此时间会被销毁
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(3), //阻塞队列, 若想长度无限, 可使用Linked
                Executors.defaultThreadFactory(),//r -> new Thread(r)
                new ThreadPoolExecutor.AbortPolicy()  //任务的拒绝策略
        );

        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
    }
}
