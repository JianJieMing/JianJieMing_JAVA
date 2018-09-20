package com.jianjieming.study.Modle.vo;

/**
 * @author 铭
 * DATE: 18/9/12 下午4:45
 */

public class User {

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }


}
