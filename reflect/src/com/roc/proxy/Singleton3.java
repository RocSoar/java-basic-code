package com.roc.proxy;

public class Singleton3<T extends Singleton3<T>> {
    //    静态内部类版本
//    因Java无法new T(), 且无法在静态方法中引用泛型参数T, 此单例工厂类无法实现, (在C#中可以实现)
    protected Singleton3() {
    }

    public static <K> K getInstance() {
        return (K) Holder.INSTANCE; // 错误, Object类型无法强转为K类型
    }

    private static class Holder {
        private static final Object INSTANCE = new Object();
    }
}
