package com.roc.test3;

import java.util.Timer;

public class CountDown {
    public static void main(String[] args) {
        Timer timer = new Timer();

//        每隔一秒执行TimeTask里的run方法
        timer.schedule(new TimeTask("2024-09-17 00:00:00"), 0, 1000);
    }
}
