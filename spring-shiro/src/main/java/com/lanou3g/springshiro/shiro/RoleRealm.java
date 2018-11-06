package com.lanou3g.springshiro.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * @author 铭
 * 2018/11/2 14:41
 */
public class RoleRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return "RoleRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        // 如果使用SimpleToken来登录,那么就由该Realm来处理登录逻辑
        return token instanceof SimpleToken;
    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 应该做的事:
        // 去数据库查询当前用户所有的角色和权限
        Subject subject = SecurityUtils.getSubject();
        // 获取用户名
        String username = (String) subject.getPrincipal();
        // 为当前用户添加角色和权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("admin");
        info.addRole("money");
        info.addStringPermission("admin:insert");
        info.addStringPermission("admin:query");
        info.addStringPermission("money:delete");
        info.addStringPermission("money:update");
        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 拿到用户名
        String username = (String) token.getPrincipal();
        // 拿到密码
        String password = (String) token.getCredentials();
        // 查询数据库
        if ("role".equals(username) && "123".equals(password)) {
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
