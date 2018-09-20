package com.jianjieming.login;

import com.jianjieming.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * @author 铭
 */
@WebServlet(name = "EnterServlet", urlPatterns = "/login")
public class EnterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner();
        HttpSession session = request.getSession();

        String sql = "select username,password from User";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password + "********");

        String validateCode = request.getParameter("code");
        String code = (String) session.getAttribute("validateCode");


        try {
            Connection conn = cpds.getConnection();
            List<User> userList = runner.query(conn, sql, new BeanListHandler<>(User.class));
            for (User user : userList) {
                String username1 = user.getUsername();
                String password1 = user.getPassword();

                if (code != null && code.equalsIgnoreCase(validateCode)) {
                    if (username.equals(username1) && password.equals(password1)) {
                        session.setAttribute("username3", username);
                        System.out.println("需要传的值" + username);
                        response.sendRedirect("main.html");
                        System.out.println("登陆成功");
                        return;
                    } else {
                        response.getWriter().write("<a href=\"login.html\" style=\"text-decoration: none;color: red\"><h1>用户名或者密码不正确,点我返回上一层</h1></a>");
                    }
                } else {
                    response.getWriter().write("<a href=\"login.html\" style=\"text-decoration: none;color: red\"><h1>验证码不正确,点我返回上一层</h1></a>");
                }
            }
            DbUtils.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        response.setHeader("refresh", "5;url=register.html");
//        response.getWriter().println("<a style=\"text-decoration: none;color: #ff0214\" href=\"register.html\">登录失败,5秒钟自动跳转到注册界面,否则点击前往</a>");
    }

}

