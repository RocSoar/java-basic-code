package com.roc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MutiCastReceive {
    public static void main(String[] args) throws IOException {
        MulticastSocket ms = new MulticastSocket(10000);

//        将当前本机, 添加到224.0.0.1这一组中, 接收组播
        InetAddress address = InetAddress.getByName("224.0.0.1");
        ms.joinGroup(address);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        ms.receive(dp);
        byte[] data = dp.getData();
        int len = dp.getLength();
        String hostAddress = dp.getAddress().getHostAddress();
        String hostName = dp.getAddress().getHostName();
        String str = new String(data, 0, len);

        System.out.println("ip为: " + hostAddress + ",主机名为: " + hostName + "的人发送了数据: " + str);

        ms.close();
    }
}
