package com.jianjieming.study.common;

import com.jianjieming.study.db.LanouDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 铭
 */
public class CustomDataSource implements ConnectionSource {
    @Override
    public Connection get() throws SQLException {
        return LanouDataSource.getInstance().getConnection();
    }
}
