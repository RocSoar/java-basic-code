package com.roc.event;

public class Test {
    public static void main(String[] args) {
        EventManager.startEvent.addListener(Test::display);
        EventManager.startEvent.addListener(Test::display2);
//        EventManager.loadEvent.removeListener(Test::display4);
        EventManager.startEvent.clearListener();
        EventManager.startEvent.triggerEvent();
//        EventManager.loadEvent.triggerEvent("呵呵呵");
    }

    public static void display() {
        System.out.println("hello");
    }

    public static void display2() {
        System.out.println("你好");
    }

    public static void display3(String str) {
        System.out.println(str);
    }

    public static void display4(String str) {
        System.out.println(str + "来自roc");
    }
}
