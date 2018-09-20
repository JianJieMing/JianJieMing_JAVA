package com.jianjieming.study.bean;

/**
 * @author 铭
 * DATE: 18/9/10 上午9:44
 */
public class PersonBean {
    private int id, age;
    private String name, sex;

    public PersonBean() {
    }

    public PersonBean(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public PersonBean(int id, int age, String name, String sex) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
