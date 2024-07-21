package com.roc;

import java.lang.reflect.*;

public class Demo {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 第一种方式
        Class<?> clazz1 = Class.forName("com.roc.Student");

        // System.out.println(clazz);
        // 第二种方式
        // Class<Student> clazz2 = Student.class;
        //// 第三种方式
        // Class<? extends Student> clazz3 = new Student().getClass();
        // System.out.println(clazz1 == clazz2 && clazz2 == clazz3);

        // 获取所有public构造, 不包括private protected
        // Constructor<?>[] cons = clazz1.getConstructors();
        // Arrays.stream(cons).forEach(c -> System.out.println(c));
        // 获取在本类声明的所有的构造, 包括private protected
        // Constructor<?>[] cons2 = clazz1.getDeclaredConstructors();
        // Arrays.stream(cons2).forEach(c -> System.out.println(c));

        // 获取单个构造
        Constructor<?> con = clazz1.getDeclaredConstructor(String.class, int.class);
        Constructor<?> con2 = clazz1.getDeclaredConstructor(int.class);
        // System.out.println(con);
        // 获取构造的权限修饰符
        // int modifiers = con.getModifiers();
        // System.out.println(modifiers);
        // 获取构造的所有参数
        // Parameter[] parameters = con.getParameters();
        // Arrays.stream(parameters).forEach(p -> System.out.println(p));

        // 暴力反射
        // con2.setAccessible(true);
        // Student s = (Student) con2.newInstance(28);
        // System.out.println(s);

        // 获取在本类声明的所有成员变量
        Field[] fields = clazz1.getDeclaredFields();
        // 获取单个成员变量
        Field declaredField = clazz1.getDeclaredField("gender");
        // 获取修饰符
        int modifiers = declaredField.getModifiers();
        // 获取名字
        String name = declaredField.getName();
        // 获取类型
        Class<?> type = declaredField.getType();
        // 获取成员变量对应的值, 需传入所在的对象
        Constructor<?> con3 = clazz1.getDeclaredConstructor(String.class);
        con3.setAccessible(true);
        Student s = (Student) con3.newInstance("男");
        declaredField.setAccessible(true);
        String value = (String) declaredField.get(s);
        // System.out.println(value); //成员变量对应的值
        // 修改成员变量的值, 需传入所在的对象
        declaredField.set(s, "女");
        // System.out.println(declaredField.get(s));

        // 方法反射
        // 获取所有的public方法, 包括继承自父类的, 不包括private protected
        Method[] methods = clazz1.getMethods();
        // 获取在本类声明的所有方法, 包括private和protected和自己的public方法
        // 不包括继承自父类的方法, 因为继承的方法不是在本类声明的
        Method[] declaredMethods = clazz1.getDeclaredMethods();
        // 获取在本类声明的单个方法, 不包括继承自父类的方法, 因为继承的方法不是在本类声明的
        Method declaredMethod = clazz1.getDeclaredMethod("sleep");
        // 获取单个public方法, 包括继承自父类的, 不包括private protected
        Method method = clazz1.getMethod("equals", Object.class);
        Method method2 = clazz1.getDeclaredMethod("add", int.class, int.class);
//        获取修饰符
        int modifiers1 = method2.getModifiers();
//        获取名字
        String name1 = method2.getName();
//        获取形参
        Parameter[] parameters = method2.getParameters();
//        获取抛出的异常
        Class<?>[] exceptionTypes = method2.getExceptionTypes();

//        运行方法
//        获取对象
        Student stu = (Student) clazz1.getConstructor().newInstance();
//        暴力反射
        method2.setAccessible(true);
//        传入调用对象和方法的实参, 获得返回值
        int res = (int) method2.invoke(stu, 1, 2);
        System.out.println(res);//打印返回值
    }
}
