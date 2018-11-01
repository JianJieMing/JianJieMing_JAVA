package com.lanou3g.tokendemo111.entity;


/**
 * @author 铭
 * 2018/11/1 15:34
 */
public class User {

    public Long userId;
    public String username;
    public String password;
    public String taken;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTaken() {
        return taken;
    }

    public void setTaken(String taken) {
        this.taken = taken;
    }
}
