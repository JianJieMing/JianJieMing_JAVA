package com.jianjieming.login;

import com.google.gson.Gson;
import com.jianjieming.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

/**
 * @author 铭
 */
@WebServlet(name = "Ajax2Servlet",urlPatterns = "/ajax2")
public class Ajax2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            Connection conn = cpds.getConnection();
            QueryRunner runner = new QueryRunner();
            String username = (String) session.getAttribute("username3");
            System.out.println("传过来的值"+username);

            String sql = "select username,sex,url,email,birth from User where username = ?";
            List<User> query = runner.query(conn, sql, new BeanListHandler<>(User.class),username);
            String s = new Gson().toJson(query);
            writer.println(s);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
