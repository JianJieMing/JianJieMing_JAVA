package com.lanou3g.demo;

import com.lanou3g.demo.utils.DBUtils;

import javax.sql.rowset.serial.SerialArray;
import java.sql.*;

public class ApiDemo {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtils.getConnection();
        // 用来设置事务是否自动提交, 默认值为true
        // 为true的情况下, 每条SQL语句都在一个事务中
        conn.setAutoCommit(false);
        // 可以预编译SQL语句
        String p = "孙";
        String sql = "select * from t_students where stu_name like ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        // 给sql中的第几个问号设置值为 什么
        ps.setString(1, p + "%");

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println(id + "  " + name);
        }

        // 提交事务
//        conn.commit();
        // 回滚事务
//        conn.rollback();


    }
}
