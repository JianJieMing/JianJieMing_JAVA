package com.lanou3g.tokendemo111.interceptor;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lanou3g.tokendemo111.utils.JwtUtils;
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
            String newtoken = JwtUtils.autoRequire(token);
            response.addHeader("Authentication", newtoken);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException("认证失败,请重新登录");
        }
    }
}
