package com.lanou3g.tokendemo111.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 铭
 * 2018/11/2 16:22
 */
public class SimpleUsernameToken implements AuthenticationToken {

    private String username;
    private String password;

    public SimpleUsernameToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
