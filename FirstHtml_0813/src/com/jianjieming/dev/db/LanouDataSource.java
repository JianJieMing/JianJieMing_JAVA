package com.jianjieming.dev.db;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 用来获取数据库连接的
 */
public class LanouDataSource {

    private static class Holder{
        private static final LanouDataSource INSTANCE =
                new LanouDataSource();
    }

    public static LanouDataSource getInstance(){
        return Holder.INSTANCE;
    }

    private ArrayBlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(10);

    private String url;
    private String user;
    private String password;

    private LanouDataSource() {
        // 为了自己使用方便
        url = "jdbc:mysql://localhost:3306/new_db";
        user = "root";
        password = "root";

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
        try {
            return pool.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void release(Connection conn){
        pool.add(conn);
    }

    public void closeAll(){
        try {
            for (Connection conn : pool) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
