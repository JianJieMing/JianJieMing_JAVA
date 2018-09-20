package com.jianjieming.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/8/30 上午11:25
 */

/*
    为了方便使用,自己创建一个过滤器的基类.
    方便:
         1. init和destroy两个方法可以根据需要重写.
         2. doFilter的参数让它支持Http协议.
 */
public abstract class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        doFilter(
                (HttpServletRequest) servletRequest,
                (HttpServletResponse) servletResponse,
                filterChain);
    }

    public abstract void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException;

    @Override
    public void destroy() {

    }
}
