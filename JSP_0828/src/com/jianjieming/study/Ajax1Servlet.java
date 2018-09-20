package com.jianjieming.study;

import com.google.gson.Gson;
import com.jianjieming.bean.UserBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
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
 * DATE: 18/8/29 上午8:16
 */
@WebServlet(name = "Ajax1Servlet", urlPatterns = "/ajax1")
public class Ajax1Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner();
        try {
            Connection conn = cpds.getConnection();
            String queryUser = "select * from t_user";
            List<UserBean> userBeanList = runner.query(conn, queryUser, new BeanListHandler<>(UserBean.class, new BasicRowProcessor(new GenerousBeanProcessor())));
            String s = new Gson().toJson(userBeanList);
            writer.println(s);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
