package com.roc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

public class MultiCastSend {
    public static void main(String[] args) throws IOException {
        MulticastSocket ms = new MulticastSocket();

        String str = "你好!";
        byte[] buffer = str.getBytes(StandardCharsets.UTF_8);
        InetAddress address = InetAddress.getByName("224.0.0.1"); //组播地址

        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, address, 10000);

        ms.send(dp);
        ms.close();
    }
}
