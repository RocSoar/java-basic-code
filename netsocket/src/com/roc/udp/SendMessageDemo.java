package com.roc.udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {

//        有参: 使用指定端口号进行绑定
//        空参: 在可用的端口中随机选择一个
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入你想发送的信息: ");
            String msg = sc.nextLine();

//        打包数据
            byte[] buffer = msg.getBytes(StandardCharsets.UTF_8);
            InetAddress address = InetAddress.getByName("127.0.0.1");
//        广播, 向局域网中所有的设备发送数据
//        InetAddress address = InetAddress.getByName("255.255.255.255");
            int port = 10086;

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);

            socket.send(packet);
            if (msg.equals("exit"))
                break;
        }

        socket.close();
    }
}
