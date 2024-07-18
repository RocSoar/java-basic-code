package com.roc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Prac1Receive {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);

        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

        while (true) {
            ds.receive(dp);
            byte[] data = dp.getData();
            int len = dp.getLength();
            String ip = dp.getAddress().getHostAddress();
            String hostName = dp.getAddress().getHostName();
            String str = new String(data, 0, len);
            System.out.println("ip为:" + ip + ",主机名为" + hostName + "的人, 发送了数据: " + str);
            if (str.equals("886"))
                break;
        }
        ds.close();
    }
}
