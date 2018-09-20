package com.jianjieming.dev.db;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanouRunner {

    private static ConnectionSource source = new C3p0DataSource();

    public static void setSource(ConnectionSource source) {
        LanouRunner.source = source;
    }

    private static void check() {
        if (source == null) {
            throw new NullPointerException("请先为source对象赋值");
        }
    }

    private LanouRunner() {
    }

    public static <T> List<T> findAll(String sql, Class<T> clazz, Object... params) {
        check();
        try {
            Connection conn = source.get();
            QueryRunner r = new QueryRunner();
            List<T> list = r.query(
                    conn,
                    sql,
                    new BeanListHandler<T>(clazz),
                    params
            );
            // 连接使用完成之后, 释放
            conn.close();
//            LanouDataSource.getInstance().release(conn);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 为了防止其他人调用该方法会获取到null对象,
        // 返回一个0 size的集合
        return new ArrayList<T>();
    }

    public static <T> T findOne(String sql, Class<T> clazz, Object... params) {
//        LanouDataSource ds = new LanouDataSource();
//        Connection conn = LanouDataSource.getInstance().getConnection();
        try {
            QueryRunner r = new QueryRunner();
            Connection conn = source.get();
            T bean = r.query(
                    conn,
                    sql,
                    new BeanHandler<>(clazz, new UnderlineProcessor()),
                    params);
//            LanouDataSource.getInstance().release(conn);
            return bean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
