package com.roc.objectstream;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student stu = new Student("roc", 25);
//        序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/object.txt"));
        oos.writeObject(stu);
        oos.close();

//        反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io/object.txt"));
        Student o = (Student) ois.readObject();
        ois.close();
        System.out.println(o.getAge());
        System.out.println(o);
    }
}
