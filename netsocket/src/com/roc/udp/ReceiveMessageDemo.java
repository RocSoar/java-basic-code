package com.roc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {

//        绑定端口, 要和发送时的端口一致
        DatagramSocket socket = new DatagramSocket(10086);

//        接受数据包
        byte[] buffer = new byte[1024 * 64]; //64KB
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        while (true) {
            socket.receive(packet);  //该方法是阻塞的

//        解析数据包
            String msg = new String(buffer, 0, packet.getLength());
//            byte[] data = packet.getData();
//            int len = packet.getLength();
            String address = packet.getAddress().getHostAddress();
            int port = packet.getPort();

//            System.out.println("接收到数据: " + new String(data, 0, len));
            System.out.println("接收到数据: " + msg);
            System.out.println("该数据是从: " + address + "这台电脑的" + port + "这个端口发出的");
            if (msg.equals("exit"))
                break;
        }

        socket.close();
    }
}
