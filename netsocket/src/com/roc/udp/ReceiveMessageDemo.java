package com.roc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {

//        绑定端口, 要和发送时的端口一致
        DatagramSocket ds = new DatagramSocket(10086);

//        接受数据包
        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        ds.receive(dp);  //该方法是阻塞的

//        解析数据包
        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();

        System.out.println("接收到数据: " + new String(data, 0, len));
        System.out.println("该数据是从: " + address + "这台电脑的" + port + "这个端口发出的");

        ds.close();
    }
}
