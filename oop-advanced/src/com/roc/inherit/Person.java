package com.roc.inherit;

public abstract class Person {
    private String name;
    private int age;

    public Person() {
//        System.out.println("Person的空参构造被调用了");
    }

    public Person(String name, int age) {
//        System.out.println("Person的有参构造被调用了");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void keepPet(Animal animal, String sth) {
        int age = animal.getAge();
        String color = animal.getColor();
        String kind = animal instanceof Dog ? "狗" : "猫";
        System.out.println("年龄为" + getAge() + "的" + getName() + "养了一只" + color + "颜色的" + age + "岁的" + kind);
        animal.eat(sth);
    }

    public void personTest() {
        if (this instanceof Student)
            System.out.println("是学生");
    }

    ;
}
