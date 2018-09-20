package com.jianjieming.study.listener;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 铭
 * DATE: 18/8/31 上午11:13
 */
public class MySessionListener
        implements
        // 监听Session的创建和销毁.
        HttpSessionListener,
        // 监听ServletContext的创建和销毁.
        ServletContextListener,
        // 监听ServletRequest的创建和销毁.
        ServletRequestListener {

    private ServletContext servletContext;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        // 每次有Session创建,这个方法都会执行一次.
        // 获取创建的Session.
        HttpSession session = httpSessionEvent.getSession();
        Integer count = (Integer) servletContext.getAttribute("user-count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        servletContext.setAttribute("user-count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        // 每次有Session销毁,这个方法都会执行一次.
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

    }
}
