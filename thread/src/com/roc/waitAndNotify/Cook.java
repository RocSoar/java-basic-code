package com.roc.waitAndNotify;

public class Cook extends Thread {
    public Cook() {
    }

    public Cook(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.class) {
                if (Desk.count >= 10)
                    break;

                if (Desk.foodFlag == 0) {
                    System.out.println(getName());
                    Desk.foodFlag = 1;
                    Desk.class.notifyAll();
                } else {
                    try {
                        Desk.class.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
