package com.roc.proxy;

public interface MyService<T> {
    public abstract T doSomething(T arg);

    public abstract void doSomethingElse();
}
