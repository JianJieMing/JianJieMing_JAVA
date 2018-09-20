package com.jianjieming.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 铭
 * DATE: 18/8/29 上午10:46
 */
@WebServlet(name = "DisplayServlet", urlPatterns = "/display")
public class DisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        // 显示用户访问该页面的次数.
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/session");
            return;
        }
        // 获取session域中,保存的数据.
        Integer times = (Integer) session.getAttribute("times");
        writer.println(times);
        writer.println(session.getId());


        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            writer.write("key:  " + name + ",value:  " + value);
        }


        // 访问次数 + 1 覆盖掉session中原来的次数.
        session.setAttribute("times", times + 1);
        writer.close();
    }
}
