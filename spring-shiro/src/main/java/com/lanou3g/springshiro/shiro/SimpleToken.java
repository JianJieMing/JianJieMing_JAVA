package com.lanou3g.springshiro.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 铭
 * 2018/11/2 14:46
 */
public class SimpleToken implements AuthenticationToken {

    private String username;
    private String password;

    public SimpleToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 获取用户名
    @Override
    public Object getPrincipal() {
        return username;
    }

    // 获取密码
    @Override
    public Object getCredentials() {
        return password;
    }
}
