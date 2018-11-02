package com.lanou3g.tokendemo111.shiro;

import com.lanou3g.tokendemo111.entity.SysPermission;
import com.lanou3g.tokendemo111.entity.SysRole;
import com.lanou3g.tokendemo111.entity.UserInfo;
import com.lanou3g.tokendemo111.service.UserInfoService;
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
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 铭
 * 2018/11/2 16:27
 */
@Component
public class SimpleRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;

    @Override
    public String getName() {
        return "simpleRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof SimpleUsernameToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 授权
        Subject subject = SecurityUtils.getSubject();
        // 因为认证的时候存储的是UserInfo对象,所以取出来的也是UserInfo对象
        UserInfo user = (UserInfo) subject.getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (SysRole role : user.getRoleList()) {
            info.addRole(role.getRole());
            for (SysPermission permission : role.getPermissions()) {
                info.addStringPermission(permission.getPermission());
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 认证
        String username = (String) token.getPrincipal();
        String password = (String) token.getCredentials();
        UserInfo user = this.userInfoService.login(username, password);
        if (user != null) {
            // 说明从数据库中可以拿到用户信息
            SimpleAuthenticationInfo info =
                    // 为了方便之后的调用,主要信息存的是该用户的详情
                    new SimpleAuthenticationInfo(user, password, getName());
            return info;
        }
        throw new AuthenticationException("登录失败");
    }
}
