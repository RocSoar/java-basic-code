package com.roc.udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {

//        有参: 使用指定端口号进行绑定
//        空参: 在可用的端口中随机选择一个
        DatagramSocket ds = new DatagramSocket();

//        打包数据
        String str = "Hello, World!";
        byte[] buffer = str.getBytes(StandardCharsets.UTF_8);
        InetAddress address = InetAddress.getByName("127.0.0.1");
//        广播, 向局域网中所有的设备发送数据
//        InetAddress address = InetAddress.getByName("255.255.255.255");
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, address, port);

        ds.send(dp);

        ds.close();
    }
}
