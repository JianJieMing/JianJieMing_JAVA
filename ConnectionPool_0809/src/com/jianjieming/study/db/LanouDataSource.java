package com.jianjieming.study.db;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * 用来获取数据库连接的
 *
 * @author 铭
 */
public class LanouDataSource {

    private static class Holder {
        private static final LanouDataSource INSTANCE =
                new LanouDataSource();
    }

    public static LanouDataSource getInstance() {
        return Holder.INSTANCE;
    }

    private String url;
    private String user;
    private String password;
    private List<Connection> pool = new Vector<>();

    private LanouDataSource() {
//        为了自己使用方便
        url = "jdbc:mysql://localhost:3306/JianJieMing";
        user = "root";
        password = "123456";

        try {
            for (int i = 0; i < 5; i++) {
                Connection conn = DriverManager.getConnection(url, user, password);
                pool.add(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接获取失败");
        }
    }

    public Connection getConnection() {
//        防止数组越界
        if (pool.size() > 0) {
            return pool.remove(0);
        }
        throw new RuntimeException("连接池中连接数量不够了");
    }

    public void release(Connection conn) {
        pool.add(conn);
    }

    public static void loadDriver(String driverName) {
        DbUtils.loadDriver(driverName);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
