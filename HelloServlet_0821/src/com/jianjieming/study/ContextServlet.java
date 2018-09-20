package com.jianjieming.study;

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
@WebServlet(name = "ContextServlet", urlPatterns = "/context")
public class ContextServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");

        // 获取ServletContext的三种方式,获取的都是同一个对象.
        ServletContext context1 = getServletContext();
        ServletContext context2 = getServletConfig().getServletContext();
        ServletContext context3 = request.getServletContext();

        /*
            在开发环境/生成环境,当前的工程目录肯定是会发生变化的.
            甚至于开发环境与生成环境的操作系统都不一样.
            所以说在使用某个路径的时候,一定要充分考虑所有不同的情况.
            该方法,可以再不同的环境下动态的获取当前工程所在的目录.
         */
        String path = context1.getRealPath("a.jpg");
//        /Users/dllo/Desktop/java/DLJ180603/课堂代码/HelloServlet_0821/out/artifacts/HelloServlet_0821_war_exploded/files
        System.out.println(path);
        response.getWriter().println(path);
    }
}
