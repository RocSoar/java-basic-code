package com.roc.objectstream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student stu = new Student("roc", 25, "taian");
        Student stu2 = new Student("gpx", 26, "shan");
        Student stu3 = new Student("susan", 27, "earth");
//        序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/object.txt"));
        List<Student> list = new ArrayList<>(List.of(stu, stu2, stu3));
        oos.writeObject(list);
        oos.close();

//        反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io/object.txt"));
        List<Student> students = (List<Student>) ois.readObject();
        ois.close();
        students.forEach(System.out::println);
    }
}
