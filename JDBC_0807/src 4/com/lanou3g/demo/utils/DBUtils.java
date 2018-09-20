package com.lanou3g.demo.utils;

import com.lanou3g.demo.config.DatabaseConfig;
import com.lanou3g.demo.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBUtils {

    static {
        // 1. 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        // 2. 获取连接
//            Properties p = new Properties();
//            p.setProperty("user", "root");
//            p.setProperty("password", "root");
//            Connection conn = DriverManager.getConnection(URL_MYSQL, p);
        try {
            Connection conn = DriverManager.getConnection(
                    DatabaseConfig.URL_MYSQL,
                    DatabaseConfig.USER,
                    DatabaseConfig.PASSWORD);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Student> execute(String sql, SqlRunnable r){
        // 1. 获取连接
        Connection conn = getConnection();
        // 2. 获取statement
        try {
            Statement statement = conn.createStatement();
            // 3. 执行sql
            // 4. 处理结果
            List<Student> students = r.execute(statement, sql);
            // 5. 关闭各种连接
            statement.close();
            conn.close();
            return students;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }


}
