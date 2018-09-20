package com.jianjieming.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/8/30 下午3:08
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/validate/*")
public class LoginFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        // 比如现在有三个页面,是不需要登录就能访问的.
        // /login.jsp   /register.jsp   /home.jsp

        // http://www.baidu.com
        // 以一定的规则来为所有的地址命名.
        // 比如说,直接能访问的地址 /open/xxx   /open/login
        // 需要登录才能访问的 /validate/xxx /validate/game-list
//        String uri = req.getRequestURI();
//        System.out.println("url:    " + uri);
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            // 如果登录了就放行.
            filterChain.doFilter(req, resp);
        } else {
            // 如果没登录,重定向到登录页面.
            resp.sendRedirect("/index.jsp");
        }

    }
}
