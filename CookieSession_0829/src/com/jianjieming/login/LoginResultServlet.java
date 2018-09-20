package com.jianjieming.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/8/29 下午4:51
 */
@WebServlet(name = "LoginResultServlet", urlPatterns = "/login-result")
public class LoginResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");

        String result;
        String msg;
        String path;

        // 判断是不是登录成功了.
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        // 如果user不为null,说明登录成功了.
        if (username == null) {
            result = "登录失败";
            msg = "5秒后跳转到登录页面";
            path = "/login.jsp";
        } else {
            result = "登录成功";
            msg = "5秒后跳转到游戏列表页面";
            path = "/game-list";
            // 如果需要设置2分钟就算浏览器关闭了,也可以免登陆.
            // 需要把JSESSIONID 这个cookie有效时长设置为2分钟.
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(20);
            response.addCookie(cookie);
        }
        request.setAttribute("result", result);
        request.setAttribute("msg", msg);
        request.setAttribute("path", path);
        // 5秒后跳转的功能.
        response.setHeader("Refresh", "5;url=" + path);
        // 请求转发到登录结果jsp页面.
        request.getRequestDispatcher("login-result.jsp").forward(request, response);
    }
}
