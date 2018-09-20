package com.jianjieming.study;

import com.jianjieming.study.bean.StudentBean;
import com.jianjieming.study.common.DbcpDataSource;
import com.jianjieming.study.db.LanouRunner;

import java.util.List;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
//        配置连接池
        LanouRunner.setSource(new DbcpDataSource());
        String sql = "select SID as stuId,Sname as stuName,Sage as birthday,Ssex as stuGender from Student where Ssex = ?";
        List<StudentBean> list = LanouRunner.findAll(sql, StudentBean.class, "男");
        list.forEach(System.out::println);

    }
}
