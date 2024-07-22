package com.roc.classLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MyClassLoader mc = new MyClassLoader("out/production/map");
        Class<?> clazz = mc.loadClass("com.roc.map.Student");
        Constructor<?> con = clazz.getDeclaredConstructor(String.class, int.class);
        con.setAccessible(true);
        Object o = con.newInstance("rocsoar", 26);
        System.out.println(o);
    }
}
