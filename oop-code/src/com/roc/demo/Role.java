package com.roc.demo;

import java.util.Objects;
import java.util.Random;

public class Role {
    private String name;
    private int health;
    private String gender;
    private String face;


    private final String[] boyFaces = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞"};
    private final String[] girlFaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹"};

    //    attack 攻击描述：
    private final String[] attack_desc = {
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };

    //    injured 受伤描述：
    private final String[] injured_desc = {
            "结果%s退了半步,毫发无损。",
            "结果给%s造成一处瘀伤。",
            "结果一击命中，%s痛得弯下腰。",
            "结果%s痛苦地闷哼了一声、显然受了点内伤。",
            "结果%s摇摇晃晃，一跤摔倒在地。",
            "结果%s脸色一下变得惨白，连退了好几步。",
            "结果『轰』的一声，%s口中鲜血狂喷而出。",
            "结果%s一声惨叫，像滩软泥般塌了下去。"};

    private final Random rand = new Random();
    private boolean isDead;

    public Role() {
    }

    public Role(String name, int health, String gender) {
        this.name = name;
        this.health = health;
        this.gender = gender;
        setFace();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public void setFace() {
        if (Objects.equals(gender, "男"))
            face = boyFaces[rand.nextInt(boyFaces.length)];
        else if (Objects.equals(gender, "女"))
            face = girlFaces[rand.nextInt(girlFaces.length)];
        else
            face = "惨不忍睹";
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void attack(Role role) {
        System.out.println();
        System.out.printf(attack_desc[rand.nextInt(attack_desc.length)], name, role.name);
        System.out.println();

        int amount = rand.nextInt(20) + 1;
//        System.out.println(name + "攻击了" + role.name + ", 造成了" + amount + "点伤害！");
        role.takeDamage(amount);
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health > 0) {
            switchText(health / 10);
        } else {
            System.out.printf("%s被K.O了！\n", name);
            health = 0;
            isDead = true;
        }
    }

    public boolean checkDead() {
        return isDead;
    }

    private void switchText(int amount) {
        switch (amount) {
            case 10, 9 -> System.out.printf(injured_desc[0], name);
            case 8 -> System.out.printf(injured_desc[1], name);
            case 7 -> System.out.printf(injured_desc[2], name);
            case 6 -> System.out.printf(injured_desc[3], name);
            case 5, 4 -> System.out.printf(injured_desc[4], name);
            case 3, 2 -> System.out.printf(injured_desc[5], name);
            case 1 -> System.out.printf(injured_desc[6], name);
            case 0 -> System.out.printf(injured_desc[7], name);
        }
    }

    public void showRoleInfo() {
        System.out.println();
        System.out.println("姓名: " + name);
        System.out.println("血量: " + health);
        System.out.println("性别: " + gender);
        System.out.println("长相: " + face);
    }

}
