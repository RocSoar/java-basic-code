package com.roc.main;

import com.roc.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentSystem {
    private final ArrayList<Student> students = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    
    public void run() {
        while (true) {
            System.out.println("\n-----------------欢迎来到学生管理系统-----------------------");
            System.out.println("1: 添加学生");
            System.out.println("2: 删除学生");
            System.out.println("3: 修改学生");
            System.out.println("4: 查询学生");
            System.out.println("5: 退出系统");
            System.out.println("请输入你的选择: ");
            String choose = sc.next();
            try {
                switch (choose) {
                    case "1" -> add();
                    case "2" -> delete();
                    case "3" -> update();
                    case "4" -> displayAll();
                    case "5" -> {
                        System.out.println("bye~");
                        System.exit(0);
                    }
                    default -> System.out.println("没有这个选项");
                }
            } catch (Exception e) {
                System.out.println("输入错误! 请重新输入!");
                System.out.println(e);
            }
            sc.nextLine();
        }
    }

    public void add() {
        String id = null;
        while (true) {
            System.out.println("请输入学生id: ");
            id = sc.next();
            if (!contains(id))
                break;
            System.out.println("该学生ID已经存在, 请勿重复添加!\n");
        }
        System.out.println("请输入学生姓名: ");
        String name = sc.next();
        System.out.println("请输入学生年龄: ");
        int age = sc.nextInt();
        System.out.println("请输入学生家庭地址: ");
        String address = sc.next();
        students.add(new Student(id, name, age, address));
        System.out.println("学生信息添加成功!");
    }

    public boolean add(Student stu) {
        if (contains(stu.getId()))
            return false;
        students.add(stu);
        return true;
    }

    public void delete() {
        System.out.println("请输入要删除的学生id: ");
        String id = sc.next();
        if (students.removeIf(s -> s.getId().equals(id)))
            System.out.println("id为" + id + "的学生删除成功! ");
        else
            System.out.println("该学生ID不存在, 删除失败!");
    }

    public void update() {
        System.out.println("请输入要修改的学生ID: ");
        String id = sc.next();
        if (contains(id)) {
            System.out.println("请输入修改后的学生姓名: ");
            String name = sc.next();
            System.out.println("请输入修改后的学生年龄: ");
            int age = sc.nextInt();
            System.out.println("请输入修改后的学生家庭地址: ");
            String address = sc.next();
            queryOne(id).update(id, name, age, address);
            System.out.println("id为" + id + "的学生修改成功! ");
        } else
            System.out.println("该学生ID不存在, 修改失败!");
    }

    public Student queryOne(String id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    /*public List<Student> test() {
        return students.stream().filter(s -> !s.getId().isEmpty()).collect(Collectors.toList());
    }

    public List<String> test2() {
        return students.stream().map(s -> s.getName()).toList();
    }*/

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("当前无学生信息, 请添加后再查询.");
            return;
        }
        System.out.printf("%-10s%-12s%-6s%-12s\n", "ID", "name", "age", "address");
        students.forEach(s -> System.out.println(s.toStr()));
    }

    private boolean contains(String id) {
        return students.stream().anyMatch(s -> s.getId().equals(id));
    }

    private int indexOf(String id) {
        return students.indexOf(queryOne(id));
    }
}
