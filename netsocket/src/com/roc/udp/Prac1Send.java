package com.roc.udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Prac1Send {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你要说的话: ");
            String str = sc.nextLine();
            byte[] buffer = str.getBytes(StandardCharsets.UTF_8);
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 10086);
            ds.send(dp);
            if (str.equals("886"))
                break;
        }
        ds.close();
    }
}
