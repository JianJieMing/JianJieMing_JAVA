package com.jianjieming.Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 铭
 */
@WebServlet(name = "AServlet", urlPatterns = "/a")
public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        request.getRequestDispatcher("/b");
        PrintWriter writer = response.getWriter();
        writer.write("我是A界面");
        writer.close();
        System.out.println("******************");
        // 获取浏览器信息
        String userAgent = request.getHeader("User-Agent");
        System.out.println("浏览器信息" + userAgent);
        System.out.println("******************");

        System.out.println("请求协议:" + request.getScheme());
        System.out.println("服务器名称:" + request.getServerName());
        System.out.println("端口号:" + request.getServerPort());
        System.out.println("项目名:" + request.getContextPath());
        System.out.println("Servlet路径:" + request.getServletPath());
        System.out.println("参数列表:" + request.getQueryString());
        System.out.println("请求的uri:" + request.getRequestURI());
        System.out.println("请求的url:" + request.getRequestURL());
        ServletContext context = request.getServletContext();
        context.setAttribute("key","我是AServlet里面的内容");
    }
}
