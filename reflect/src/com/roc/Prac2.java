package com.roc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Prac2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties prop = new Properties();
        File file = new File("reflect/test.properties");
//        加载配置
        prop.load(new FileInputStream(file));
//        获得字节码文件
        Class<?> clazz = Class.forName(prop.getProperty("classname"));
//        获得空参构造
        Constructor<?> con = clazz.getConstructor();
//        创建对象
        Object obj = con.newInstance();
//        获得方法
        Method method = clazz.getDeclaredMethod(prop.getProperty("method"));
//        暴力反射
        method.setAccessible(true);
//        调用方法
        Object res = method.invoke(obj);
        System.out.println(res);
    }
}
