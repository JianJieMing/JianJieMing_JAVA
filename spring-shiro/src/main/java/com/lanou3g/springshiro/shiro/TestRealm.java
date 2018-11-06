package com.lanou3g.springshiro.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author 铭
 * 2018/11/2 11:20
 */
public class TestRealm implements Realm {
    @Override
    public String getName() {
        return "TestRealm";
    }

    /**
     * 用来判断自定义的Realm是否支持某个Token
     * 前提: 在登录的时候,需要调用login方法,并传递一个Token对象
     * 如果把该Realm设置给SecurityManager,那么在使用Shiro登录的时候
     * 登录的逻辑就在该Realm里
     * 所以就得判断一下,该Realm是否可以处理login时传递进来的Token
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 拿到用户名
        String username = (String) token.getPrincipal();
        // 拿到密码
        char[] tempPassword = (char[]) token.getCredentials();
        String password = new String(tempPassword);
        // 查询数据库
        if ("admin".equals(username) && "admin".equals(password)) {
            // 登录成功
            AuthenticationInfo authenticationInfo =
                    new SimpleAuthenticationInfo(username, password, getName());
            return authenticationInfo;
        } else {
            // 登录失败
            throw new AuthenticationException("用户名或密码错误");
        }
    }
}
