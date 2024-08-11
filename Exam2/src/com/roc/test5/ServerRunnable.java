package com.roc.test5;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class ServerRunnable implements Runnable {
    private static final File file = new File("Exam2/userInfo.txt");
    private static final Properties prop = new Properties();
    private final Socket socket;
    private final DataInputStream dis;
    private final DataOutputStream dos;

    static {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            prop.load(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ServerRunnable(Socket socket) throws IOException {
        this.socket = socket;
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        System.out.println("有客户端连接了");
        while (true) {
            try {
                switch (readFromClient()) {
                    case "login" -> login();
                    case "register" -> register();
                    case "exit" -> {
                        exit();
                        return;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void login() throws IOException {
        System.out.println("用户选择了登录操作");
        String data = readFromClient();
        String[] ss = data.split("=");

        if (ss.length != 2) {
            writeToClient("403");
            return;
        }
        synchronized (prop) {
            if (!prop.containsKey(ss[0])) {
                writeToClient("404");
                return;
            }
            if (!prop.getProperty(ss[0]).equals(ss[1])) {
                writeToClient("404");
                return;
            }
        }
        writeToClient("200");
    }

    private void register() throws IOException {
        System.out.println("用户选择了注册操作");
        String data = readFromClient();
        String[] ss = data.split("=");

        if (ss.length != 2) {
            writeToClient("403");
            return;
        }
        synchronized (prop) {
            if (prop.containsKey(ss[0])) {
                writeToClient("404");
                return;
            }
            prop.setProperty(ss[0], ss[1]);
            prop.store(new FileWriter(file), "name=password");
        }
        writeToClient("201");
    }

    private void exit() throws IOException {
        writeToClient("Bye~");
        dis.close();
        dos.close();
        socket.close();
        System.out.println("有客户端退出了");
    }

    private String readFromClient() throws IOException {
        return dis.readUTF();
    }

    private void writeToClient(String msg) throws IOException {
        dos.writeUTF(msg);
        dos.flush();
    }
}
