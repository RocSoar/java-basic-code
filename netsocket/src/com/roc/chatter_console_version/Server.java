package com.roc.chatter_console_version;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    ServerSocket ss = new ServerSocket(10000);
    //    线程池大小, 最大支持24个客户端同时连接
    static ThreadPoolExecutor pool = new ThreadPoolExecutor(24, 24, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws IOException {
        new Server();
    }

    public Server() throws IOException {
        run();
    }

    public void run() throws IOException {
        //只要来了一个客户端，就开一条线程处理
        while (true)
            pool.submit(new ServerRunnable(ss.accept()));
    }
}
