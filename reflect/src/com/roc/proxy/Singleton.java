package com.roc.proxy;

public class Singleton {
    //    双重检查锁定模式
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance != null)
            return instance;
        synchronized (Singleton.class) {
            if (instance == null)
                instance = new Singleton();
        }
        return instance;
    }
}
