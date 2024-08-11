package com.roc.browser_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    ServerSocket ss = new ServerSocket(8080);
    ThreadPoolExecutor pool = new ThreadPoolExecutor(28,
            28,
            0,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(8),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws IOException {
        new Server();
    }

    public Server() throws IOException {
        while (true) {
            Socket socket = ss.accept();
            System.out.println("GET " + socket.getRemoteSocketAddress());
            pool.execute(new ServerRunnable(socket));
        }
    }
}
