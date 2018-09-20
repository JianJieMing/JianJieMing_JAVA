package com.jianjieming.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/8/28 下午3:41
 */
@WebServlet(name = "LoginView", urlPatterns = "/login.do")
public class LoginView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用请求转发的方式,访问受限的页面.
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        // request 域对象

    }
}
