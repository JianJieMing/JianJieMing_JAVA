package com.jianjieming.study.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * 创建人: 武奇
 * 创建事件: 2018/8/31
 */
public class User
        implements Serializable,
        HttpSessionActivationListener,
        HttpSessionBindingListener {

    private int id;
    private String username;
    private String password;
    private boolean loginStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        // 钝化
        System.out.println("钝化");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        // 活化
        System.out.println("活化");
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 当然类的对象如果存放到了Session中,
        // 该方法就会执行
        loginStatus = true;
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        loginStatus = false;
        // 当当前对象, 从session中移除的时候,
        // 该方法会执行
    }
}
