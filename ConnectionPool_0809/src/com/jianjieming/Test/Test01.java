package com.jianjieming.Test;

import com.jianjieming.study.bean.StudentBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 铭
 */
public class Test01 {
    public static void main(String[] args) {

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner();
        try {
            Connection conn = cpds.getConnection();
            String sql = "select SID as stuId,Sname as stuName,Sage as birthday,Ssex as stuGender from Student where Ssex = ?";
            List<StudentBean> list = runner.query(conn, sql, new BeanListHandler<>(StudentBean.class), "男");
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
