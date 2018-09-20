package com.jianjieming.study;

import com.jianjieming.bean.HeaderImageBean;
import com.jianjieming.bean.UserBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 铭
 * DATE: 18/8/28 上午11:24
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login.action")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // 获取上传用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String hint3 = "恭喜你登录成功!";
        String hint4 = "<h1>很遗憾登录失败</h1><br><a href=\"../login.html\" style=\"text-decoration: none\"><input type=\"button\" value=\"返回登录界面\"></a>\n";

        ComboPooledDataSource ds = new ComboPooledDataSource();
        HttpSession session2 = request.getSession();
        String validateCode = request.getParameter("code");
        String code = (String) session2.getAttribute("validateCode");
        try {
            Connection conn = ds.getConnection();
            QueryRunner runner = new QueryRunner();
            ServletContext context = request.getServletContext();
            String userQuery = "select * from t_user where username = ?";
            Object[] userValues = {username};
            UserBean user = runner.query(conn, userQuery, new BeanHandler<>(UserBean.class, new BasicRowProcessor(new GenerousBeanProcessor())), userValues);
            if (code != null && code.equalsIgnoreCase(validateCode)) {
                if (password != null && user != null && password.equals(user.getPassword())) {
                    // 登录成功了 根据用户的imageId来查询他的头像信息
                    String imgQuery = "select * from t_header_image where image_id = ?";
                    Object[] imgValues = {user.getImageId()};
                    HeaderImageBean header = runner.query(conn, imgQuery, new BeanHandler<>(HeaderImageBean.class, new BasicRowProcessor(new GenerousBeanProcessor())), imgValues);

                    // 把头像信息存储到session中
                    HttpSession session = request.getSession();
                    session.setAttribute("header", header);
                    String username1 = user.getUsername();
                    String password1 = user.getPassword();
                    request.setAttribute("username", username1);
                    context.setAttribute("user", username1);
                    session.setAttribute("un", username1);
                    session.setAttribute("pw", password1);
                    Cookie cookie = new Cookie("JSESSIONID", session.getId());
                    cookie.setMaxAge(60 * 60);
                    response.addCookie(cookie);
//                writer.println("<br>");
//                writer.println("头像为: ");
                    // 显示图片, src中填写的是登录的用户的头像地址
//                writer.println("<img src=\"own-header\"/>");
                    request.setAttribute("img", "own-header");
                    request.setAttribute("hint", hint3);
                    request.getRequestDispatcher("WEB-INF/hint.jsp").forward(request, response);
                } else {
                    request.setAttribute("hint", hint4);
                    request.getRequestDispatcher("WEB-INF/hint.jsp").forward(request, response);
                }
            } else {
                response.getWriter().write("<a href=\"login.html\" style=\"text-decoration: none;color: red\"><h1>验证码不正确,点我返回上一层</h1></a>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
