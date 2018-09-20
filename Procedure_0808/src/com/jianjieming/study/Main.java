package com.jianjieming.study;

import java.sql.*;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        /*
            使用JDBC操作过程.
         */
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JianJieMing",
                    "root",
                    "123456");
//            CallableStatement 用来调用过程的.
            CallableStatement call = conn.prepareCall("{call query_stu}");
//            执行过程,一般会用executeQuery()方法.
            ResultSet resultSet = call.executeQuery();
//            结果集的处理跟普通查询一样
//            while (resultSet.next()) {
//                String sname = resultSet.getString("Sname");
//                System.out.println(sname);
//            }
//            获取过程中out参数的值.
            CallableStatement out = conn.prepareCall("{call insert_stu(?,?,?,?,?)}");
            out.setInt(1,77);
            out.setString(2,"赵日天");
            out.setDate(3, Date.valueOf("1899-06-06"));
            out.setString(4,"男");
//            注册输出参数,设置过程中的第几个问号的数据类型是什么.
            out.registerOutParameter(5,Types.INTEGER);
//            调用过程.
            out.executeQuery();
//            过程调用完毕之后,取出out参数的值.
            int qty = out.getInt(5);
            System.out.println(qty);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
