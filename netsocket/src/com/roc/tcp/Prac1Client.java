package com.roc.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Prac1Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);
        OutputStream os = socket.getOutputStream();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的消息: ");
            String s = sc.nextLine();
            os.write(s.getBytes(StandardCharsets.UTF_8));
            if (s.equals("886"))
                break;
        }

        socket.close();
    }
}
