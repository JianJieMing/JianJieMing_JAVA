package com.jianjieming.study.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author 铭
 * DATE: 18/8/31 上午11:30
 */

// 域对象的属性监听器
@WebListener
public class AttributeListener
        implements
        // 监听Session域对象属性的变化.
        HttpSessionAttributeListener,
        // 监听ServletContext域对象属性的变化.
        ServletContextAttributeListener,
        // 监听ServletRequest域对象属性的变化.
        ServletRequestAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        // 第一次向Session中存值,该方法会执行.

        // 这一次向Session中存值得时候的name.
        String name = httpSessionBindingEvent.getName();
        // 获取对应的值.
        Object value = httpSessionBindingEvent.getValue();
        HttpSession session = httpSessionBindingEvent.getSession();

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }
}
