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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

/**
 * @author 铭
 */
@WebServlet(name = "Ajax1Servlet", urlPatterns = "/ajax1")
public class Ajax1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            Connection conn = cpds.getConnection();
            QueryRunner runner = new QueryRunner();
            String sql = "select username,sex,url,email,birth from User";
            List<User> query = runner.query(conn, sql, new BeanListHandler<>(User.class));
            String s = new Gson().toJson(query);
            writer.println(s);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
