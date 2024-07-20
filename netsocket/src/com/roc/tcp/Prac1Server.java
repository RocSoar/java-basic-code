package com.roc.tcp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Prac1Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);
        Socket socket = ss.accept();
        System.out.println("客户端已连接");
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        char[] buffer = new char[1024];
        int len;
        while ((len = isr.read(buffer)) != -1)
            System.out.println(new String(buffer, 0, len));

        socket.close();
        ss.close();
    }
}
