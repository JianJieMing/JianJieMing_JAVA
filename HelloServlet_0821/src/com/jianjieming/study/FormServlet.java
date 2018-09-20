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
@WebServlet(name = "FormServlet", urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        // Post请求设置编码格式.
        // 这个设置只对Post请求生效.
        request.setCharacterEncoding("utf8");
        doGet(request, response);
    }

    // GET请求接收前端发送过来的数据
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("utf8");
//        request.setCharacterEncoding("utf8");

        // 在Servlet中如何接收前端传递过来的数据.
        String username = request.getParameter("username");
//        byte[] bytes = username.getBytes("iso-8859-1");
//        username = new String(bytes, "utf-8");
        response.getWriter().write(username);

    }
}
