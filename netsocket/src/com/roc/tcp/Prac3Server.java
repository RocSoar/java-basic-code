package com.roc.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Prac3Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

//        创建线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,  //核心线程数量
                24,               //最大线程数量
                60,              //空闲时间
                TimeUnit.SECONDS, //空闲时间(单位)
                new ArrayBlockingQueue<>(2),//阻塞队列
                Executors.defaultThreadFactory(), //线程工厂, 让线程池如何创建线程对象
                new ThreadPoolExecutor.AbortPolicy() //拒绝策略
        );

        while (true) {
            Socket socket = ss.accept();
            System.out.println("客户端已连接");
//            new Thread(new MyRunnable(socket)).start();
            pool.submit(new MyRunnable(socket));
        }

//        ss.close();
    }
}
