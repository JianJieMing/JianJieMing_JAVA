package com.jianjieming.study.db;

import com.jianjieming.study.common.ConnectionSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class LanouRunner {

    private static ConnectionSource source;

    public static void setSource(ConnectionSource source) {
        LanouRunner.source = source;
    }

    private static void check() {
        if (source == null) {
            throw new NullPointerException("请先为source对象赋值");
        }
    }

    //    private static final ComboPooledDataSource SOURCE;
//    private static DataSource ds;
//
//    static {
//
//        Properties prop = new Properties();
//        prop.setProperty("user","root");
//        prop.setProperty("password","123456");
//        try {
//            prop.load(new FileReader("src/db.properties"));
//            ds = BasicDataSourceFactory.createDataSource(prop);
//         } catch (Exception e) {
//            e.printStackTrace();
//            ds = null;
//        }


//        SOURCE = new ComboPooledDataSource();
    // 创建连接池核心工具类
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//           设置连接参数：url、驱动、用户密码、初始连接数、最大连接数
//        try {
//            dataSource.setDriverClass("com.mysql.jdbc.Driver");
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/JianJieMing");
//        dataSource.setUser("root");
//        dataSource.setPassword("123456");
//        dataSource.setInitialPoolSize(3);
//        dataSource.setMaxPoolSize(6);
//        dataSource.setMaxIdleTime(1000);
// ---> 从连接池对象中，获取连接对象
//        Connection con = dataSource.getConnection();
//    }

//    private static LanouDataSource ds = new LanouDataSource();

    private LanouRunner() {

    }

    public static <T> List<T> findAll(String sql, Class<T> clazz, Object... params) {
        check();
//        Connection conn = LanouDataSource.getInstance().getConnection();
        Connection conn = null;
        try {
            conn = source.get();
            QueryRunner runner = new QueryRunner();
            List<T> tList = runner.query(
                    conn,
                    sql,
                    new BeanListHandler<>(clazz),
                    params
            );
//            连接使用完成之后,释放
//            LanouDataSource.getInstance().release(conn);
            conn.close();
            return tList;
        } catch (SQLException e) {
            e.printStackTrace();

        }
//        为了防止其他人调用该方法会获取到null对象,返回一个0 size的集合.
        return new ArrayList<>();
    }

}
