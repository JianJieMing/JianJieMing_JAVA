package com.jianjieming.study;

import com.google.gson.Gson;
import com.jianjieming.bean.UserBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletContext;
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
 * DATE: 18/8/29 上午8:54
 */
@WebServlet(name = "Ajax2Servlet",urlPatterns = "/ajax2")
public class Ajax2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner();
        ServletContext context = request.getServletContext();
        try {
            Connection conn = cpds.getConnection();
            String user = (String) context.getAttribute("user");
            System.out.println(user);
            String queryUsername = "select * from t_user where username = ?";
            List<UserBean> userBeanList = runner.query(conn, queryUsername, new BeanListHandler<>(UserBean.class, new BasicRowProcessor(new GenerousBeanProcessor())),user);
            String s = new Gson().toJson(userBeanList);
            writer.println(s);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
