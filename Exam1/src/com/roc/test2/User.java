package com.roc.test2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private long id;
    private String name;
    private String gender;
    private LocalDate birthday;
    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public User() {
    }

    public User(long id, String name, String gender, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public User(String str) {
        String[] ss = str.split(":");
        this.id = Long.parseLong(ss[0]);
        this.name = ss[1];
        this.gender = ss[2];
        this.birthday = LocalDate.parse(ss[3], df);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
