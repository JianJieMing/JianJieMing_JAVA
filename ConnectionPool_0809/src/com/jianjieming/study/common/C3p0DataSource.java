package com.jianjieming.study.common;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 铭
 */

/*
    使用c3p0的连接池
 */
public class C3p0DataSource implements ConnectionSource {

    private ComboPooledDataSource source = new ComboPooledDataSource();

    @Override
    public Connection get() throws SQLException {
        return source.getConnection();
    }
}
