package com.roc.proxy;

public class MyServiceImpl implements MyService<String> {
    @Override
    public String doSomething(String arg) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "做了一些事情基于" + arg;
    }

    @Override
    public void doSomethingElse() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("做了一些事情...");
    }
}
