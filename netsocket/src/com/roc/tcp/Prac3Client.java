package com.roc.tcp;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Prac3Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);
        File file = new File("netsocket/break loop.png");

//        发送文件名, 此处代码有bug,尚未解决
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//        pw.println(file.getName());
//        pw.flush();

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
//        发送文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1)
            bos.write(buffer, 0, len);
        bos.flush();
        socket.shutdownOutput();

//        接收服务器回传信息
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null)
            System.out.println(line);

        bis.close();
        socket.close();
    }
}
