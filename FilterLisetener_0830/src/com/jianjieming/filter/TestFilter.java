package com.jianjieming.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/8/30 上午10:39
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 生命周期方法.
        // 当这个过滤器对象创建的时候会执行.
        // 一个过滤器只会创建一个对象.
        // 也就是这个方法只会执行一次.
        System.out.println("TestFilter.init");
//        String charset = filterConfig.getInitParameter("charset");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("在放行之前执行");
        // 放行.
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("在放行之后执行");
    }

    @Override
    public void destroy() {
        // 生命周期方法.
        // 当这个过滤器对象销毁的时候,会执行该方法.
        System.out.println("TestFilter.destroy");
    }
}
