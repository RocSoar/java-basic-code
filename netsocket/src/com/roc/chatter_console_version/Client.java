package com.roc.chatter_console_version;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client {
    //  线程池大小, 最大支持24个客户端同时启动
    static ThreadPoolExecutor pool = new ThreadPoolExecutor(24, 24, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    Scanner sc = new Scanner(System.in);
    Socket socket = new Socket("127.0.0.1", 10000);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    public static void main(String[] args) throws IOException {
        new Client();
    }

    public Client() throws IOException {
        run();
    }

    private void run() throws IOException {
        System.out.println("服务器连接成功!");
        while (true) {
            System.out.println("===========欢迎来到聊天室============");
            System.out.println("请选择:");
            System.out.println("1.登录");
            System.out.println("2.注册");

            switch (sc.nextLine()) {
                case "1" -> login();
                case "2" -> register();
                default -> System.out.println("请输入1或2!");
            }
        }
    }

    private void login() throws IOException {
        System.out.println("请输入用户名:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String pwd = sc.nextLine();

        String data = name + "=" + pwd;

//        向服务器发送登录请求
        sendMsgToServer("login");

//        向服务器发送用户数据
        sendMsgToServer(data);

//        接收服务器回传
        switch (br.readLine()) {
            case "1" -> {
                System.out.println("登录成功!可以开始聊天了");
                talkToAll();
            }
            case "2" -> System.out.println("密码错误, 请重新输入!");
            case "3" -> System.out.println("该用户不存在!请注册后再登录!");
            case "5" -> System.out.println("用户名或密码格式不正确! 请重新输入!");
            default -> System.out.println("发生了未知错误!");
        }
    }

    private void register() throws IOException {
        System.out.println("请输入用户名:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String pwd = sc.nextLine();
        System.out.println("请再次输入密码:");
        String rePwd = sc.nextLine();
        if (!pwd.equals(rePwd)) {
            System.out.println("两次密码输入不一致, 请重新输入!");
            return;
        }
        String data = name + "=" + pwd;
        //  向服务器发送注册请求
        sendMsgToServer("register");

        //   向服务器发送用户数据
        sendMsgToServer(data);

        //   接收服务器回传
        switch (br.readLine()) {
            case "1" -> {
                System.out.println("注册成功!可以开始聊天了");
                talkToAll();
            }
            case "4" -> System.out.println("该用户名已存在! 请重新输入!");
            case "5" -> System.out.println("用户名或密码格式不正确! 请重新输入!");
            default -> System.out.println("发生了未知错误!");
        }
    }

    private void talkToAll() throws IOException {
//        开启一条新线程来不停监听其他人发送的消息
        pool.submit(new ClientRunnable(socket));
//        向服务器发送消息
        while (true) {
            System.out.println("请输入你想说的话:");
            sendMsgToServer(sc.nextLine());
        }
    }

    private void sendMsgToServer(String msg) throws IOException {
        bw.write(msg);
        bw.newLine();
        bw.flush();
    }
}
