package com.jianjieming.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 铭
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        PrintWriter writer = response.getWriter();
        // 获取前端发送过来的验证码
        String code = request.getParameter("code");
        // 获取session中保存的验证码
        HttpSession session = request.getSession();
        String validateCode = (String) session.getAttribute("validateCode");
        if (validateCode!=null&&validateCode.equalsIgnoreCase(code)){
            writer.println("<h1>验证成功</h1>");
        } else {
            writer.println("<h1>验证失败</h1>");
        }


    }
}
