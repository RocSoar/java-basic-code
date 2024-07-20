package com.roc.chatter_console_version;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServerRunnable implements Runnable {
    Socket socket;
    static List<Socket> socketList = new ArrayList<>();
    static File userFile = new File("netsocket/userinfo.txt");
    static final Lock fileLock = new ReentrantLock();
    static final Lock socketLock = new ReentrantLock();
    static Properties userProp = new Properties();
    static int count = 0;
    BufferedWriter bw;
    BufferedReader br;
    String username;
    int id;

    static {
        fileLock.lock();
        try {
            userProp.load(new FileInputStream(userFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fileLock.unlock();
        }
    }

    public ServerRunnable(Socket socket) throws IOException {
        synchronized (ServerRunnable.class) {
            System.out.println("客户端" + ++count + "已连接");
            id = count;
        }
        this.socket = socket;
        bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        while (true) {
            try {
                String msg = br.readLine();
                switch (msg) {
                    case "login" -> login();
                    case "register" -> register();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void login() throws IOException {
        System.out.println("客户端" + id + "请求登录");
        String data = br.readLine();
        System.out.println("客户端" + id + "发送了数据 ---> " + data);
        String[] userInfo = data.split("=");
        if (userInfo.length != 2) {
            // 用户名或密码格式不正确
            sendMsgToClient("5");
            return;
        }
        String name = userInfo[0];
        String pwd = userInfo[1];
        if (!userProp.containsKey(name)) {
            // 用户名不存在
            sendMsgToClient("3");
        } else if (!userProp.getProperty(name).equals(pwd)) {
            // 密码错误
            sendMsgToClient("2");
        } else {
            // 登录成功
            System.out.println("用户 " + name + " 已登录");
            sendMsgToClient("1");
            username = name;
            
            socketLock.lock();
            try {
                socketList.add(socket);
            } finally {
                socketLock.unlock();
            }
            talkToAll();
        }
    }

    private void register() throws IOException {
        System.out.println("客户端" + id + "请求注册");
        String data = br.readLine();
        System.out.println("客户端" + id + "发送了数据 ---> " + data);
        String[] userInfo = data.split("=");
        if (userInfo.length != 2) {
            // 用户名或密码格式不正确
            sendMsgToClient("5");
            return;
        }
        String name = userInfo[0];
        String pwd = userInfo[1];
        if (userProp.containsKey(name)) {
            // 用户名已存在
            sendMsgToClient("4");
        } else if (!validate(name, pwd)) {
            // 用户名或密码格式不正确
            sendMsgToClient("5");
        } else {
            // 注册成功
            System.out.println("用户 " + name + " 已注册");
            sendMsgToClient("1");
            username = name;

            fileLock.lock();
            try {
                userProp.setProperty(name, pwd);
                userProp.store(new FileOutputStream(userFile), "username=password");
            } finally {
                fileLock.unlock();
            }

            socketLock.lock();
            try {
                socketList.add(socket);
            } finally {
                socketLock.unlock();
            }
            talkToAll();
        }
    }

    private void talkToAll() throws IOException {
        while (true) {
//            监听该客户端发送的消息
            String msg = br.readLine();
            System.out.println(username + "说: " + msg);
            socketLock.lock();
            try {
//                向所有客户端 群发消息
                for (Socket s : socketList) {
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                    bw.write(username + "说: " + msg);
                    bw.newLine();
                    bw.flush();
                }
            } finally {
                socketLock.unlock();
            }
        }
    }

    //    用户名与密码校验
    private boolean validate(String name, String pwd) {
        return name.matches("\\w{4,16}") && pwd.matches("\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[A-Z])(?=\\S*[a-z])(?=\\S*[!@#$%^&*?])\\S*");
    }

    private void sendMsgToClient(String msg) throws IOException {
        bw.write(msg);
        bw.newLine();
        bw.flush();
    }
}
