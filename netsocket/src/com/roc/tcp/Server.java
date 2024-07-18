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

//        监听客户端的连接,连上后, 返回客户端的连接对象, 阻塞方法
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();

//        byte[] buffer = new byte[1024];
//        int len;
//        while ((len = is.read(buffer)) != -1) {
//            System.out.println(new String(buffer, 0, len));
//        }

//      或者使用转换流转成字符流去读取
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
//        char[] buffer = new char[1024];
//        int len;
//        while ((len = isr.read(buffer)) != -1) {
//            System.out.println(new String(buffer, 0, len));
//        }
        System.out.println(br.readLine());

        is.close();
        socket.close();
        ss.close();
    }
}
