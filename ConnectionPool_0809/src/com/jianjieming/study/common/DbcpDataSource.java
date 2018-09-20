package com.jianjieming.study.common;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
/**
 * @author 铭
 */

/*
    使用dbcp连接池
 */
public class DbcpDataSource implements ConnectionSource {

    private DataSource source;

    public DbcpDataSource() {
        Properties prop = new Properties();
        try {
            prop.load(new FileReader("src/db.properties"));
            source = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection get() throws SQLException {
        return source.getConnection();
    }
}
