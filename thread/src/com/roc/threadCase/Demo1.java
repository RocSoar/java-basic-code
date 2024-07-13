package com.roc.threadCase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo1 {
    public static void main(String[] args) throws Exception {
//        MyThread t1 = new MyThread("线程1");
//        MyThread2 t2 = new MyThread2("线程2");
//        MyThread3 t3 = new MyThread3("线程3");
//        t3.setDaemon(true);
//        t1.start();
//        t2.start();
//        t3.start();  // 调用完start之后, t3线程才转为就绪状态, 开始抢夺cpu的执行权
//        t3.join();  //插入线程, 把t3线程插入到当前线程(main)之前, 确保t3线程全部执行完才执行main线程
//        Thread.yield(); //出让线程, 把cpu的执行权让出, main线程从运行状态转为就绪状态, 开始再次抢夺cpu的执行权
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName() + "---->" + i);
//        }

//        MyRunnable mr = new MyRunnable();
//        Thread t1 = new Thread(mr, "线程1");
//        Thread t2 = new Thread(mr, "线程2");
//        t1.start();
//        t2.start();

//        MyCallable mc = new MyCallable();
//        FutureTask<Integer> ft = new FutureTask<>(mc);
//        Thread t = new Thread(ft);
//        t.start();
//        Integer result = ft.get();
//        System.out.println(result);

//        ThreadLock tl1 = new ThreadLock("线程1");
//        ThreadLock tl2 = new ThreadLock("线程2");
//        ThreadLock tl3 = new ThreadLock("线程3");
//        tl1.start();
//        tl2.start();
//        tl3.start();

        DeadLock dl = new DeadLock();
        Thread t1 = new Thread(dl, "线程A");
        Thread t2 = new Thread(dl, "线程B");
        t1.start();
        t2.start();
    }
}
