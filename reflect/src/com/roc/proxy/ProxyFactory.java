package com.roc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    //    使用静态内部类实现单例模式
    private ProxyFactory() {
    }

    public static ProxyFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final ProxyFactory INSTANCE = new ProxyFactory();
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxy(T target, InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxy(T target, HandlerType handlerType) {
        InvocationHandler handler = switch (handlerType) {
            case TIMING -> new TimingInvocationHandler(target);
            case LOGGING -> new LoggingInvocationHandler(target);
        };
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxy(T target, HandlerType... handlerTypes) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new ChainedInvocationHandler(target, handlerTypes));
    }
}
