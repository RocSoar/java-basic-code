package com.roc.browser_server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ServerRunnable implements Runnable {
    Socket socket;

    public ServerRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println();
            ps.println("<div style='color:red;font-size:120px;text-align:center'>Hello, World!</div>");
            ps.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
