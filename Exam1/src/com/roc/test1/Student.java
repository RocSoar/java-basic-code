package com.roc.test1;

import java.util.Objects;

public class Student {
    private int ID;
    private int pos;

    public Student(int ID, int pos) {
        this.ID = ID;
        this.pos = pos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return ID == student.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", pos=" + pos +
                '}';
    }
}
