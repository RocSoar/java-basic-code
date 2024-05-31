package com.roc.demo;

public class Test {
    public static void main(String[] args) {
        Role role1 = new Role("乔峰", 100, "男");
        Role role2 = new Role("鸠摩智", 100, "男");
        role1.showRoleInfo();
        role2.showRoleInfo();

        while (true) {
            role1.attack(role2);

            if (role2.checkDead())
                break;

            role2.attack(role1);
            if (role1.checkDead())
                break;
        }
    }
}
