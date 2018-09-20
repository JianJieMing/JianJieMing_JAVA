package com.jianjieming.bookstore.model.vo;

/**
 * @author 铭
 * DATE: 18/9/12 下午3:08
 */
public class User {
    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
