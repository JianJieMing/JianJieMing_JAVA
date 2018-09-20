package com.jianjieming.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/8/29 下午4:35
 */
@WebServlet(name = "GameListServlet", urlPatterns = "/game-list")
public class GameListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // 标识当前的用户是否登录了.
        boolean isLogin = username != null;

        if (isLogin) {
            // 如果登录了,访问受限页面.
            request.getRequestDispatcher("/game-list.jsp").forward(request, response);
        } else {
            // 如果没登录,访问登录页面.
            // 重定向到登录页面.
            response.sendRedirect("/login.jsp");
        }
    }
}
