package com.roc.prac2;

public class Student {
    private String name;
    private String gender;
    private int age;
    private double weight;

    public Student() {
    }

    public Student(String name, String gender, int age, double weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }

    public Student(String line) {
        String[] ss = line.split("-");
        name = ss[0];
        gender = ss[1];
        age = Integer.parseInt(ss[2]);
        weight = Double.parseDouble(ss[3]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String writeToFile() {
        return name + "-" + gender + "-" + age + "-" + weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
