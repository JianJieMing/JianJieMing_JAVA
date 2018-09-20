package com.jianjieming.homework.person;

/**
 * 父类: 人类
 * 职员类
 * 工人和收银员的父类
 *
 * @author 铭
 */
public class Staff extends Person {
    private String profession;
    private int ud;

    public int getUd() {
        return ud;
    }

    public void setUd(int ud) {
        this.ud = ud;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
