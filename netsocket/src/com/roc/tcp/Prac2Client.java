package com.roc.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Prac2Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);

        OutputStream os = socket.getOutputStream();
        os.write("哈哈哈".getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();

//        接收来自服务器的回传
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int b;
        while ((b = isr.read()) != -1)
            System.out.print((char) b);

        isr.close();
        socket.close();
    }
}
