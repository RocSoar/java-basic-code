package com.roc.test4;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> ml = new MyArrayList<>();

        for (int i = 0; i < 12; i++) {
            ml.add(String.valueOf((char) (i + 65)));
        }

        ml.add("rocsoar");
        ml.add("roc");
        ml.add("susan");
        ml.add("david");
        ml.set(0, "哈哈哈");
        ml.set("哈哈哈", "嘻嘻嘻");
        ml.set(ml.length() - 1, "测试试");
        ml.remove("测试试");
        ml.remove(0);
        ml.forEach(e -> System.out.println(e));
        System.out.println(ml.length());
        System.out.println(ml.capacity());
        System.out.println(ml);
//        System.out.println(s);
    }
}
