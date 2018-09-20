package com.jianjieming.homework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jianjieming.bean.ScoreBean;
import com.jianjieming.bean.StudentBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JianJieMing",
                    "root",
                    "123456");

            QueryRunner runner = new QueryRunner();
            String sql = "select SID as stuId,Sname as stuName,Sage as birthday,Ssex as stuGender from Student";
            String sql2 = "select * from SC where SID = ?";
            List<StudentBean> query = runner.query(conn, sql, new BeanListHandler<>(StudentBean.class));
            for (StudentBean studentBean : query) {
                List<ScoreBean> scoreBeans = runner.query(conn, sql2, new BeanListHandler<>(ScoreBean.class), studentBean.getStuID());
                studentBean.setScoreBeanList(scoreBeans);
            }
            System.out.println(query);

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            Writer writer = new FileWriter("Student.json");
            String s = gson.toJson(query);
            writer.write(s);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
