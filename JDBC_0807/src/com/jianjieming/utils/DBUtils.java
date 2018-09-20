package com.jianjieming.utils;

import com.jianjieming.config.DatebaseConfig;
import com.jianjieming.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author 铭
 */
public class DBUtils {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(
                    DatebaseConfig.URL_MYSQL,
                    DatebaseConfig.USER,
                    DatebaseConfig.PASSWORD);
//            System.out.println(conn.getClass().getName());
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Student> execute(String sql, ResultHandler r) {
//        1. 获取连接
        Connection conn = getConnection();
        Statement statement = null;
        try {
//        2. 获取statement
            statement = conn.createStatement();
//        3. 执行sql
//        4. 处理结果
            List<Student> students = r.handle(statement, sql);
//        5. 关闭各种连接
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            IOUtil.closeAll(conn, statement);
        }
        return null;
    }


}
