package com.jianjieming.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/8/28 下午3:53
 */
@WebServlet(name = "Login2Servlet", urlPatterns = "/login2.action")
public class Login2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收表单上传的数据.
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 验证登录是否成功.
        // 做一个假的登录校验.
        String msg;
        if ("admin".equals(username) && "admin".equals(password)) {
            // 成功
            msg = "恭喜你登录成功了!";
        } else {
            // 失败
            msg = "你谁啊,不认识?";
        }
        // 把消息数据存储到Request域中.
        request.setAttribute("msg", msg);
        // 无论成功还是失败,都转发到这个页面.
        request.getRequestDispatcher("WEB-INF/result.jsp").forward(request, response);

        /*
            结论:
            请求转发会把请求中的所有内容,都转发过去.
            响应头可以转发,响应体转发不了.
         */
    }
}
