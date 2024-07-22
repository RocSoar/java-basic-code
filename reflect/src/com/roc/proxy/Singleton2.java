package com.roc.proxy;

public class Singleton2 {
    //    静态内部类版本
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }
}
