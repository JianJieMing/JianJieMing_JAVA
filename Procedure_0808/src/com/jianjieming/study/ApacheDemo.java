package com.jianjieming.study;

import com.jianjieming.bean.StudentBean;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * @author 铭
 */
public class ApacheDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JianJieMing",
                    "root",
                    "123456");
            QueryRunner runner = new QueryRunner();
            String sql = "delete from SC where SID = ? and CID = ?";
            Object[] params = {1, 1};
//            runner.update(conn, sql, 1, 1);
            int num = runner.update(conn, sql, params);
            if (num > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
//            DbUtils.close(conn);

//            查询******************************
            QueryRunner qr = new QueryRunner();
            String query = "select SID as stuId,Sname as stuName,Sage as birthday,Ssex as stuGender from Student where Ssex = ?";
//            String query = "select * from Student where Ssex = ?";
            Object[] p = {"男"};
//            RowProcessor processor = new BasicRowProcessor(new GenerousBeanProcessor());
            List<StudentBean> beanList = qr.query(
                    conn,
                    query,
//                    new BeanListHandler<>(StudentBean.class, processor),
//                    new BeanListHandler<>(StudentBean.class, new UnderlineProcessor()),
                    new BeanListHandler<>(StudentBean.class),
                    p);
            beanList.forEach(System.out::println);
//            ResultSetHandler 查询单条语句
            String singleSql = "select SID as stuId,Sname as stuName,Sage as birthday,Ssex as stuGender from Student where SID = ?";
            QueryRunner singleRunner = new QueryRunner();
            StudentBean stu = singleRunner.query(
                    conn,
                    singleSql,
                    new BeanHandler<>(StudentBean.class),
                    3
            );
            System.out.println(stu);
            DbUtils.close(conn);
            DbUtils.commitAndCloseQuietly(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
