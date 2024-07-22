package com.roc.proxy;

public class StarImpl implements Star {
    @Override
    public String sing(String name) {
        System.out.println("正在唱" + name);
        return "谢谢";
    }

    @Override
    public void dance() {
        System.out.println("正在跳舞");
    }
}
