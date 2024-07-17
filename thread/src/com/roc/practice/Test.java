package com.roc.practice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyThread mt = new MyThread("窗口一");
//        MyThread mt2 = new MyThread("窗口二");
//        mt.start();
//        mt2.start();

//        MyRunnable mr = new MyRunnable();

//        Thread t1 = new Thread(mr, "线程1");
//        Thread t2 = new Thread(mr, "线程2");
//        t1.start();
//        t2.start();
//        MyThread2 mt1 = new MyThread2("张三");
//        MyThread2 mt2 = new MyThread2("李四");
//        MyThread2 mt3 = new MyThread2("王五");
//        MyThread2 mt4 = new MyThread2("赵六");
//        MyThread2 mt5 = new MyThread2("田七");
//        mt1.start();
//        mt2.start();
//        mt3.start();
//        mt4.start();
//        mt5.start();

//        MyRunnable2 mr = new MyRunnable2();
//        Thread t1 = new Thread(mr, "抽奖箱1");
//        Thread t2 = new Thread(mr, "抽奖箱2");
//        t1.start();
//        t2.start();

//        Prac6 p1 = new Prac6("抽奖箱1");
//        Prac6 p2 = new Prac6("抽奖箱2");
//        p1.start();
//        p2.start();

        Prac7 p = new Prac7();
        FutureTask<Integer> ft1 = new FutureTask<>(p);
        FutureTask<Integer> ft2 = new FutureTask<>(p);

        Thread t1 = new Thread(ft1, "抽奖箱1");
        Thread t2 = new Thread(ft2, "抽奖箱2");
        t1.start();
        t2.start();
        int r1 = ft1.get();
        int r2 = ft2.get();
        int max = Math.max(r1, r2);
        String name = r1 > r2 ? "抽奖箱1" : "抽奖箱2";
        System.out.println("在此次抽奖过程中, " + name + "产生了最大奖项, 该奖项金额为" + max);
    }
}
