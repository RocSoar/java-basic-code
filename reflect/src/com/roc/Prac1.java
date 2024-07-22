package com.roc;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Prac1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
//        获取类的字节码
        Class<?> stuClazz = Class.forName("com.roc.Student");
        Class<?> teClazz = Class.forName("com.roc.Teacher");
//        获取构造方法
        Constructor<?> stuCon = stuClazz.getConstructor(String.class, int.class, String.class, double.class, String.class);
        Constructor<?> teCon = teClazz.getConstructor(String.class, double.class);
//        创建对象
        Student stu = (Student) stuCon.newInstance("roc", 28, "男", 180, "学习");
        Teacher te = (Teacher) teCon.newInstance("susan", 10000);

//        创建Properties
//        Properties stuProp = new Properties();
//        Properties teProp = new Properties();
        File stuFile = new File("reflect/student.txt");
        File teFile = new File("reflect/teacher.txt");
        PrintWriter stuPW = new PrintWriter(stuFile);
        PrintWriter tePW = new PrintWriter(teFile);

//        遍历field
        for (Field field : stuClazz.getDeclaredFields()) {
            field.setAccessible(true);
//            stuProp.setProperty(field.getName(), field.get(stu).toString());
            stuPW.println(field.getName() + "=" + field.get(stu).toString());
        }
        for (Field field : teClazz.getDeclaredFields()) {
            field.setAccessible(true);
//            teProp.setProperty(field.getName(), field.get(te).toString());
            tePW.println(field.getName() + "=" + field.get(te).toString());
        }
//存储至本地
//        stuProp.store(new FileWriter(stuFile, StandardCharsets.UTF_8), "Student Prop");
//        teProp.store(new FileWriter(teFile, StandardCharsets.UTF_8), "Teacher Prop");
        stuPW.close();
        tePW.close();
    }
}
