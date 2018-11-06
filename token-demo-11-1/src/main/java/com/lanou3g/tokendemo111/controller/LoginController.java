package com.lanou3g.tokendemo111.controller;

import com.lanou3g.tokendemo111.shiro.SimpleUsernameToken;
import com.lanou3g.tokendemo111.utils.ResuleWrapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 铭
 * 2018/11/1 15:45
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public ResuleWrapper login(@Param("username") String username, @Param("password") String password) {
//        User user = new User();
//        user.setUserId(1L);
//        user.setUsername("admin");
//        user.setPassword("666666");
//        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
//            String token = JwtUtils.newToken(user.getUserId());
//            return ResuleWrapper.success(token);
//        } else {


        // 调用Shiro的登录,然后登录成功之后获取到token
        SimpleUsernameToken token = new SimpleUsernameToken(
                username, password
        );
        SecurityUtils.getSubject().login(token);
        String jetToken = (String) SecurityUtils.getSubject().getPrincipal();
        return ResuleWrapper.success(jetToken);
//    }
    }

    @RequestMapping("/index")
    public String index() {
        return "Success";
    }

}
