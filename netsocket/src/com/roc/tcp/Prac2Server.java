package com.roc.tcp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Prac2Server {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(10000);
        Socket socket = ss.accept();
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());

        int b;
        while ((b = isr.read()) != -1)
            System.out.print((char) b);

//        向客户端发送回传
        OutputStream os = socket.getOutputStream();
        os.write("服务器已收到你的信息".getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();

        isr.close();
        socket.close();
        ss.close();
    }
}
