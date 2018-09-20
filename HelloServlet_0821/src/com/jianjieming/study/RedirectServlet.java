package com.jianjieming.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 铭
 */
@WebServlet(name = "RedirectServlet", urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        // 发送重定向
//        response.sendRedirect("http://www.baidu.com");
        // 请求转发
//        request.getRequestDispatcher("/register.html").forward(request,response);
        // 隔几秒钟跳转到某个页面
//        response.setHeader("refresh", "5;url=http://www.baidu.com");
//        response.getWriter().println("<a style=\"text-decoration: none\" href=\"http://www.baidu.com\">5秒钟自动跳转,否自自己点击</a>");
    }
}
