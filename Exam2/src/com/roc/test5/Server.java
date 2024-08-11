package com.roc.test5;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(28, 28, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(8), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        ServerSocket ss = new ServerSocket(10086);

        while (true)
            pool.execute(new ServerRunnable(ss.accept()));
    }
}
