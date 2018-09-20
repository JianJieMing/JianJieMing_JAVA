package com.jianjieming.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class ApiDemo {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtils.getConnection();
//        用来设置是否自动提交,默认值是true
//        为true的情况下,每条sql语句都在一个事务中.
        conn.setAutoCommit(false);
//        可以预编译sql语句
        String sql = "select * from Student where Sname LIKE ?";
        PreparedStatement statement = conn.prepareStatement(sql);
//        给sql中的第几个问号,设置值为什么.
        statement.setString(1,"孙%");
        ResultSet resultSet = statement.executeQuery();
        List<String> list = new ArrayList<>();
        while (resultSet.next()){
            String sname = resultSet.getString("Sname");
            list.add(sname);
        }
            System.out.println(list);

//        conn.commit(); 提交事务
//        conn.rollback(); 回滚事务
    }
}
