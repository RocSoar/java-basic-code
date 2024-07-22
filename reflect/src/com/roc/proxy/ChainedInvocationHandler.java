package com.roc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ChainedInvocationHandler implements InvocationHandler {
    private final Object target;
    private final HandlerType[] handlerTypes;

    public ChainedInvocationHandler(Object target, HandlerType... handlerTypes) {
        this.target = target;
        this.handlerTypes = handlerTypes;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (HandlerType handlerType : handlerTypes) {
            InvocationHandler handler = switch (handlerType) {
//                TODO: more handler
                case LOGGING -> new LoggingInvocationHandler(target);
                case TIMING -> new TimingInvocationHandler(target);
            };
            handler.invoke(proxy, method, args);
        }
        return method.invoke(target, args);
    }
}
