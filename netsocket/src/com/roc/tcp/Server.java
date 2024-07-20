package com.roc.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

//        监听客户端的连接,连上后, 返回客户端的连接对象, 若无客户端连接, 阻塞
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();

//        byte[] buffer = new byte[1024];
//        int len;
//        while ((len = is.read(buffer)) != -1) {
//            System.out.println(new String(buffer, 0, len));
//        }

//      或者使用转换流转成字符流去读取
        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
        char[] buffer = new char[1024];
        int len;

        //若连接通道中无数据且没有遇到EOF, read方法阻塞, 直至客户端发送数据 或遇到EOF标记 或客户端关闭连接(此时返回-1)
//        read方法会从连接通道中读取数据
//        只有遇到EOF结束标记, 循环才会停止
//        否则read方法阻塞, 等待读取数据
        while ((len = isr.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }
//        System.out.println(br.readLine());

        isr.close();
        is.close();
        socket.close();
        ss.close();
    }
}
