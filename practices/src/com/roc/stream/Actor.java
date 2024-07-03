package com.roc.stream;

public class Actor {
    String name;
    int age;

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Actor(String s) {
        this.name = s.split(",")[0];
        this.age = Integer.parseInt(s.split(",")[1]);
    }

    public String getName() {
        return name;
    }

    public String concat() {
        return name + "-" + age;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
