package com.jianjieming.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/8/29 上午10:25
 */
@WebServlet(name = "SessionServlet", urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 参数 boolean 类型,表示在获取session对象的时候,
        // 如果此时session没有,是否创建一个,默认值true.
        HttpSession session = request.getSession();
        // 获取session的id.
        // 每个用户的sessionId都是不同的.
        String id = session.getId();
        // 默认session在服务器的内存中,保存30分钟.
        // 在用户每次访问服务器的时候,这个时间都会刷新.
        session.setMaxInactiveInterval(10);

        session.setAttribute("times", 1);
        // 重定向到DisplayServlet.
        response.sendRedirect("/display");
        // 使session失效.
        session.invalidate();

/*
        出现的问题: 直接访问 /display 的时候,
        与预期的情况不一致,显示出了null,
        页面显示null,说明系统正确的获取到了session,
        并且session中没有保存times这条数据.
        原因: 启动tomcat之后,会直接打开index.jsp页面,
        在这个页面中,虽然说没有写req.getSession(),
        但是,系统也会自动创建出一个session.
        所以第一次访问display页面可以获取到session,
        导致false这个参数的运行情况和预期的不一致.
        解决办法: 在启动配置中,取消勾选 Open Browser.
        这样一来tomcat启动后,就不会自动打开首页.
*/

    }
}
