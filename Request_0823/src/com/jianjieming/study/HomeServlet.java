package com.jianjieming.study;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 铭
 */

public class HomeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        PrintWriter writer = response.getWriter();

        // 获取请求方法
        String method = request.getMethod();
        // 获取请求头
        // User=Agent: 保存的是这一次请求所使用的浏览器信息.
        String agent = request.getHeader("User-Agent");
        // Referer 表示当前的Servlet是从哪个地址访问过来的.
        String referer = request.getHeader("Referer");
        // 获取用户的ip地址
        String addr = request.getRemoteAddr();
        if (addr.endsWith("5")) {
            response.sendError(406);
            return;
        }
        // 获取查询参数,即问号后面的部分,uname=abc&password=xxx
        String queryString = request.getQueryString();

        // 域对象之一 Session Request
        // 作为域对象的作用: 能存值,能取值.
        ServletContext context = request.getServletContext();
        // ServletContext 全局的,所有的Servlet中数据是共享的.
        Integer attribute = (Integer) context.getAttribute("ctx-count");
        if (attribute == null) {
            attribute = 1;
        } else {
            attribute++;
        }
        context.setAttribute("ctx-count", attribute);
        // 所有客户端访问当前Servlet的次数
        writer.println("<h1>" + attribute + "</h1>");

        // Session会话,一个客户端多次产生的请求,试一次会话.
        HttpSession session = request.getSession();
        Integer session2 = (Integer) session.getAttribute("session-count");
        if (session2 == null) {
            session2 = 1;
        } else {
            session2++;
        }
        session.setAttribute("session-count", session2);
        writer.println("<h1>" + session2 + "</h1>");

        // Request

        writer.println("请求方式:   " + method);
        writer.println("浏览器信息:  " + agent);
        writer.println("IP地址:   " + addr);
        writer.println("访问地址:   " + referer);
        writer.close();

    }
}
