package com.roc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyJUnit {

    @MyTest
    public void test1() {
        System.out.println("执行了test1");
    }

    @MyTest
    public void test2() {
        System.out.println("执行了test2");
    }

    public void test3() {
        System.out.println("执行了test3");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<MyJUnit> clazz = MyJUnit.class;
        MyJUnit o = clazz.getConstructor().newInstance();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(MyTest.class))
                method.invoke(o);
        }
    }
}
