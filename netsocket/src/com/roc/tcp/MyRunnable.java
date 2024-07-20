package com.roc.tcp;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRunnable implements Runnable {
    private final Socket socket;
    private BufferedOutputStream bos;

    public MyRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        File fileDir = new File("netsocket/serverDir");

        try {
//        接收文件名, 此处代码有bug,尚未解决
//            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String uuid = UUID.randomUUID().toString().replace("-", "");
//            String fileName = uuid + "-" + br.readLine();
            String fileName = uuid + ".png";

//        接收文件, 并用获得的文件名创建文件
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(new File(fileDir, fileName)));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1)
                bos.write(buffer, 0, len);
            bos.flush();

//        向客户端发送回传
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            pw.println("服务器已收到你上传的文件, 上传成功!");
            pw.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bos.close();
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
