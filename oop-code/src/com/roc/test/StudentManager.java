package com.roc.test;

public class StudentManager {
    private Student[] stuArr;
    private int num;

    public StudentManager(int num) {
        this.num = num;
        setupStuArr();
    }

    private void setupStuArr() {
        stuArr = new Student[num];
        for (int i = 0; i < stuArr.length; i++) {
            stuArr[i] = new Student();
        }
    }

    public boolean add(Student stu) {
        if (contains(stu)) {
            System.out.println("请不要重复添加ID!");
            return false;
        }

        int empty = getEmptyPlace();
        if (empty != -1) {
            stuArr[empty] = stu;
        } else {
            Student[] newArr = new Student[stuArr.length * 2 + 1];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = new Student();
            }
            for (int i = 0; i < stuArr.length; i++) {
                newArr[i] = stuArr[i];
            }
            newArr[stuArr.length] = stu;
            stuArr = newArr;
        }
        return true;
    }

    public boolean remove(int id) {
        if (!contains(id)) {
            System.out.println("该ID不存在!");
            return false;
        }

        Student[] newArr = new Student[stuArr.length - 1];
        for (int i = 0, j = 0; i < newArr.length; i++, j++) {
            if (stuArr[j].getId() == id)
                j++;
            newArr[i] = stuArr[j];
        }
        stuArr = newArr;
        return true;
    }

    public boolean update(int id, Student stu) {
        int index = indexOf(id);
        if (index == -1) {
            System.out.println("该ID不存在!");
            return false;
        }
        stuArr[index] = stu;
        return true;
    }

    public Student find(int id) {
        for (Student student : stuArr) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    public void printAll() {
        for (Student student : stuArr) {
            student.print();
        }
    }

    private int indexOf(int id) {
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getId() == id)
                return i;
        }
        return -1;
    }

    private boolean contains(Student stu) {
        for (Student student : stuArr) {
            if (student.getId() == stu.getId())
                return true;
        }
        return false;
    }

    private boolean contains(int id) {
        for (Student student : stuArr) {
            if (student.getId() == id)
                return true;
        }
        return false;
    }

    private int getEmptyPlace() {
        for (int i = 0; i < stuArr.length; i++) {
            if (stuArr[i].getId() == 0)
                return i;
        }
        return -1;
    }

    private boolean isFull() {
        for (Student student : stuArr) {
            if (student.getId() == 0)
                return false;
        }
        return true;
    }

}
