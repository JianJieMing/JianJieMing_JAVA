package com.lanou3g.tokendemo111.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 铭
 * 2018/11/6 9:42
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
