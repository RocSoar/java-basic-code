package com.roc.test5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Scanner sc = new Scanner(System.in);
    private final Socket socket = new Socket("127.0.0.1", 10086);
    private final DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    private final DataInputStream dis = new DataInputStream(socket.getInputStream());

    public Client() throws IOException {
        run();
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }

    public void run() throws IOException {
        while (true) {
            System.out.println("---------------------------------------------------------");
            System.out.println("请选择: ");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出系统");
            switch (sc.nextLine()) {
                case "1" -> login();
                case "2" -> register();
                case "3" -> exit();
                default -> System.out.println("没有这个功能, 请重新输入");
            }
        }
    }

    private void login() throws IOException {
        writeToServer("login");
        writeToServer(getData());

        switch (readFromServer()) {
            case "200" -> System.out.println("登录成功!");
            case "404" -> System.out.println("用户名不存在或密码错误!");
            case "403" -> System.out.println("输入的数据格式不正确!");
        }
    }

    private void register() throws IOException {
        writeToServer("register");
        writeToServer(getData());

        switch (readFromServer()) {
            case "201" -> System.out.println("注册成功!");
            case "404" -> System.out.println("该用户名已存在, 请重新输入!");
            case "403" -> System.out.println("输入的数据格式不正确!");
        }
    }

    private void exit() throws IOException {
        writeToServer("exit");
        System.out.println(readFromServer());
        dis.close();
        dos.close();
        socket.close();
        System.exit(0);
    }

    private void writeToServer(String msg) throws IOException {
        dos.writeUTF(msg);
        dos.flush();
    }

    private String readFromServer() throws IOException {
        return dis.readUTF();
    }

    private String getData() {
        while (true) {
            System.out.println("请输入用户名: ");
            String name = sc.nextLine();
            System.out.println("请输入密码: ");
            String pwd = sc.nextLine();
            if (!name.isBlank() && !pwd.isBlank())
                return name + "=" + pwd;
            System.out.println("用户名或密码不能为空!");
        }
    }
}
