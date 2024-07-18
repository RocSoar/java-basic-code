package com.roc.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {

//        创建Socket对象, 在创建对象的同时会连接服务端, 如果连接不上会报错
        Socket socket = new Socket("127.0.0.1", 10000);

//        可以从连接通道中获取输出流
        OutputStream os = socket.getOutputStream();
        os.write("你好!".getBytes(StandardCharsets.UTF_8));
        os.write("哈哈哈rocsoar".getBytes(StandardCharsets.UTF_8));

        os.close();
        socket.close();
    }
}
