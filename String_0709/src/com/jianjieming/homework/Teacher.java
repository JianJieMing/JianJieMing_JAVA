package com.jianjieming.homework;

public class Teacher {
    private String name;
    private int age;
    private String sex;

    public void introduce() {
        System.out.println(setName("张三已经") + setAge(33) + "岁了," + setSex("性别男,爱好女!"));
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public int setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
            return age;
        } else {
            this.age = age;
            System.out.print("不是人的");
            return age;
        }
    }

    public String setSex(String sex) {
        this.sex = sex;
        return sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

}
