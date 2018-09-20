package com.jianjieming.config;

/**
 * 数据库配置
 *
 * @author 铭
 */
public final class DatebaseConfig {

    //    构造方法私有化.
    private DatebaseConfig() {
    }

    public static final String URL_MYSQL = "jdbc:mysql://localhost:3306/JianJieMing";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
}
