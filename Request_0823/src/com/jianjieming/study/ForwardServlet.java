package com.jianjieming.study;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 铭
 */
@WebServlet(name = "ForwardServlet", urlPatterns = "/forward")
public class ForwardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher home = request.getRequestDispatcher("home");
        home.forward(request, response);

        /*
            请求转发url地址不变,可以隐藏正真处理这个请求的Servlet.
            一般用来隐藏真正的页面地址.

            请求转发和重定向的区别:
            1. 请求转发,客户端浏览器的url不变,但是重定向是变化的.
            2. 请求转发,只能转发到自己的服务器资源上,但是重定向可以定向到任意网站.
            3. 请求转发浏览器只发起一次请求,但是重定向两次请求.
            4. 请求转发是服务器的行为,重定向是客户端的行为.
            5. 请求转发,在转发到的Servlet的中,任然可以获取请求中的所有数据.
               但是重定向获取不到.请求头,请求体都可以正常转发.
         */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
