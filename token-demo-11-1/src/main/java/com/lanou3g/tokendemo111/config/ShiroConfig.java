package com.lanou3g.tokendemo111.config;

import com.lanou3g.tokendemo111.shiro.JwtRealm;
import com.lanou3g.tokendemo111.shiro.SimpleRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * 2018/11/2 17:01
 */
// 配置文件类的注解
@Configuration
public class ShiroConfig {

    // 验证登录用户
    @Resource
    private SimpleRealm simpleRealm;

    // 验证token
    @Resource
    private JwtRealm jwtRealm;

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager =
                new DefaultWebSecurityManager();
//        securityManager.setRealm(simpleRealm);
        List<Realm> realms = new ArrayList<>();
        realms.add(simpleRealm);
        realms.add(jwtRealm);
        securityManager.setRealms(realms);
        securityManager.setSessionManager(new DefaultSessionManager());
        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }
}
