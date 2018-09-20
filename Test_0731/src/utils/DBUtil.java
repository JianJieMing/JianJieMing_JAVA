package utils;

import config.DatebaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

/**
 * @author 铭
 */
public class DBUtil {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(
                    DatebaseConfig.URL_MYSQL,
                    DatebaseConfig.USER,
                    DatebaseConfig.PASSWORD
            );
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> execute(String sql, ResultHandler<T> r) {
        Connection conn = getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            List<T> studens = r.handle(statement, sql);
            statement.close();
            conn.close();
            return studens;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.closeAll(conn, statement);
        }
        return null;
    }

}
