package com.roc.waitAndNotify;

public class Foodie extends Thread {
    public Foodie(String name) {
        super(name);
    }

    public Foodie() {
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.class) {
                if (Desk.count >= 10)
                    break;

                if (Desk.foodFlag == 0) {
                    try {
                        Desk.class.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println(getName() + "--->" + (++Desk.count));
                    Desk.foodFlag = 0;
                    Desk.class.notifyAll();
                }
            }
        }
    }
}
