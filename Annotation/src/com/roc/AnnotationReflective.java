package com.roc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationReflective {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("com.roc.Demo");
        Method testMethod = clazz.getDeclaredMethod("test");

        Annotation[] as = clazz.getDeclaredAnnotations();
//        System.out.println(Arrays.toString(as));
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = clazz.getDeclaredAnnotation(MyAnnotation.class);
//            System.out.println(annotation.aaa());
//            System.out.println(annotation.bbb());
//            System.out.println(Arrays.toString(annotation.ccc()));
        }

//        System.out.println(Arrays.toString(testMethod.getAnnotations()));
        if (testMethod.isAnnotationPresent(MyAnnotation2.class)) {
            MyAnnotation2 annotation2 = testMethod.getDeclaredAnnotation(MyAnnotation2.class);
            System.out.println(annotation2.value());
        }
        if (testMethod.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = testMethod.getDeclaredAnnotation(MyAnnotation.class);
            System.out.println(annotation.aaa());
        }
    }
}
