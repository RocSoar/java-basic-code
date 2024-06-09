package com.roc.main;

import com.roc.data.User;
import com.roc.utils.CheckCode;
import com.roc.validate.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private final ArrayList<User> users = new ArrayList<>();
    StudentSystem ss = new StudentSystem();

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n-----------------欢迎来到学生管理系统-----------------------");
            System.out.println("1: 登录");
            System.out.println("2: 注册");
            System.out.println("3: 忘记密码");
            System.out.println("4: 查看用户");
            System.out.println("5: 退出系统");
            System.out.println("请输入你的选择: ");
            String choose = sc.next();
            try {
                switch (choose) {
                    case "1" -> login();
                    case "2" -> register();
                    case "3" -> forgetPassword();
                    case "4" -> displayUsers();
                    case "5" -> {
                        System.out.println("bye~");
                        System.exit(0);
                    }
                    default -> System.out.println("没有这个选项!");
                }
            } catch (Exception e) {
                System.out.println("输入错误! 请重新输入!");
            }
            sc.nextLine();
        }
    }

    private void login() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名: ");
            String username = sc.next();
            if (!contains(username)) {
                System.out.println("用户名" + username + "未注册, 请注册后再登录!");
                return;
            }
            System.out.println("请输入密码: ");
            String pwd = sc.next();
            while (true) {
                String rightCode = CheckCode.generateCheckCode(5);
                System.out.println("请输入验证码: " + rightCode);
                String checkCode = sc.next();
                if (checkCode.equalsIgnoreCase(rightCode)) {
                    System.out.println("验证码输入正确");
                    break;
                }
                System.out.println("验证码输入不正确, 请重新输入!");
            }
            if (validateUser(new User(username, pwd, null, null))) {
                System.out.println("登录成功! 可以开始使用学生管理系统了");
                ss.run();
                return;
            } else {
                System.out.println("登陆失败, 用户名或密码错误!");
                if (i == 2)
                    System.out.println("当前账号" + username + "被锁定, 请联系系统管理员处理!");
                else
                    System.out.println("用户名或密码错误, 还剩下" + (2 - i) + "次机会!");
            }
        }
    }

    private void register() {
        Scanner sc = new Scanner(System.in);
        String username;
        String pwd;
        String personID;
        String pn;
        while (true) {
            System.out.println("请输入用户名: ");
            username = sc.next();
            if (!Validate.validateUsername(username)) {
                System.out.println("用户名格式不正确, 请重新输入!");
                continue;
            }
            if (contains(username)) {
                System.out.println("用户名" + username + "已存在, 请重新输入!");
                continue;
            }
            System.out.println("用户名" + username + "可用");
            break;
        }
        while (true) {
            System.out.println("请输入要注册的密码: ");
            pwd = sc.next();
            System.out.println("请再次输入要注册的密码: ");
            String confirmPwd = sc.next();
            if (pwd.equals(confirmPwd)) {
                System.out.println("两次密码输入一致, 请继续录入其他数据");
                break;
            }
            System.out.println("两次密码输入不一致, 请重新输入!");
        }
        while (true) {
            System.out.println("请输入身份证号码: ");
            personID = sc.next();
            if (Validate.validatePersonID(personID)) {
                System.out.println("身份证号码录入正确");
                break;
            }
            System.out.println("身份证号码格式不正确, 请重新输入!");
        }
        while (true) {
            System.out.println("请输入手机号码: ");
            pn = sc.next();
            if (Validate.validatePhoneNumber(pn)) {
                System.out.println("手机号码录入正确");
                break;
            }
            System.out.println("手机号码格式不正确, 请重新输入!");
        }
        users.add(new User(username, pwd, personID, pn));
        System.out.println("用户" + username + "注册成功!");
        displayUsers();
    }

    private void forgetPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        User user = queryOne(username);
        if (user == null) {
            System.out.println("用户名不存在!");
            return;
        }
        System.out.println("请输入身份证号码:");
        String id = sc.next();
        System.out.println("请输入手机号码:");
        String pn = sc.next();
        if (!(user.getPersonID().equalsIgnoreCase(id) && user.getPhoneNumber().equals(pn))) {
            System.out.println("账号信息不匹配, 修改失败!");
            return;
        }
        while (true) {
            System.out.println("请输入修改后的新密码:");
            String pwd = sc.next();
            System.out.println("请再次输入新密码:");
            String confirmPwd = sc.next();
            if (pwd.equals(confirmPwd)) {
                user.setPassword(pwd);
                System.out.println("密码修改成功!");
                break;
            }
            System.out.println("两次密码输入不一致, 请重新输入!");
        }
    }

    private boolean contains(String username) {
        return users.stream().anyMatch(u -> u.getUsername().equals(username));
    }

    private boolean validateUser(User user) {
        return users.stream().
                anyMatch(u -> u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()));
    }

    public User queryOne(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("当前无用户信息, 请注册后再查询.");
            return;
        }
        System.out.printf("%-16s%-12s%-20s%-12s\n", "Username", "Password", "PersonID", "PhoneNumber");
        users.forEach(u -> System.out.println(u.toStr()));
    }
}
