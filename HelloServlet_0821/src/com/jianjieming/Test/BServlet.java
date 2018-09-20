package com.jianjieming.Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 铭
 */
@WebServlet(name = "BServlet", urlPatterns = "/b")
public class BServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
//        response.sendRedirect("/a");

        ServletContext context = request.getServletContext();
        String key = (String) context.getAttribute("key");
        key += "我经过了BServlet";
        response.getWriter().write(key);
        context.setAttribute("Bkey", key);
    }
}
