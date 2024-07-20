package com.roc.chatter_console_version;

import java.io.*;
import java.net.Socket;

public class ClientRunnable implements Runnable {
    Socket socket;
    BufferedReader br;

    public ClientRunnable(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
//        监听其他人发送的消息 并打印
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true)
                System.out.println(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
