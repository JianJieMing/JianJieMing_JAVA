package com.jianjieming.study;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 铭
 */
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("出生了");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("获取配置信息");
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        PrintWriter pr = resp.getWriter();
        pr.println("Hello HelloServlet");
        pr.close();
        System.out.println("每次刷新浏览器都会执行");
    }

    @Override
    public String getServletInfo() {
        System.out.println("描述信息");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("死亡了");
    }
}
