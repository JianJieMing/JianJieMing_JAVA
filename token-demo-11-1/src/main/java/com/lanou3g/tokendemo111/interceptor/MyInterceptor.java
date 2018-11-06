package com.lanou3g.tokendemo111.interceptor;

import com.lanou3g.tokendemo111.shiro.JwtToken;
import com.lanou3g.tokendemo111.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 铭
 * 2018/11/1 16:32
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authentication");
        try {
//            String newtoken = JwtUtils.autoRequire(token);

            JwtToken jwtToken = new JwtToken(token);
            SecurityUtils.getSubject().login(jwtToken);
            String netToken = (String) SecurityUtils.getSubject().getPrincipal();

            response.addHeader("Authentication", netToken);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException("认证失败,请重新登录");
        }
    }
}
