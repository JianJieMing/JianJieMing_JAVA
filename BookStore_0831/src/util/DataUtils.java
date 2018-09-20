package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class DataUtils {

    private static final class SingletonHolder {
        private static final DataUtils INSTANCE = new DataUtils();
    }

    public static DataUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private ComboPooledDataSource ds;

    private DataUtils() {
        ds = new ComboPooledDataSource();
    }

    /**
     * 获取数据库连接
     *
     * @return 数据库连接对象
     * @throws SQLException SQL执行异常
     */
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 插入单条数据的方法. 在一个事务中.
     *
     * @param sql    SQL语句
     * @param params 参数
     * @return 插入后, 该条数据的主键. 主键必须是表中的第一列, 并且为整数类型.
     * @throws SQLException SQL执行异常
     */
    public Long insert(String sql, Object... params) throws SQLException {
        QueryRunner r = new QueryRunner(ds);
        return r.insert(sql, new ScalarHandler<>(1), params);
    }

    /**
     * 插入单条数据的方法. 不在事务中, 可以自由的控制事务
     *
     * @param conn   数据库连接对象
     * @param sql    SQL语句
     * @param params 参数
     * @return 插入后, 该条数据的主键. 主键必须是表中的第一列, 并且为整数类型.
     * @throws SQLException SQL执行异常
     */
    public Long insert(Connection conn, String sql, Object... params) throws SQLException {
        QueryRunner r = new QueryRunner();
        return r.insert(conn, sql, new ScalarHandler<>(1), params);
    }

    /**
     * 可以执行insert/delete/update语句. 默认在一个事务中.
     *
     * @param sql    SQL语句
     * @param params 参数
     * @return 影响表中数据的条数
     * @throws SQLException SQL执行异常
     */
    public int update(String sql, Object... params) throws SQLException {
        QueryRunner r = new QueryRunner(ds);
        return r.update(sql, params);
    }

    /**
     * 可以执行insert/delete/update语句. 不在事务中, 可以自由控制事务.
     *
     * @param conn   数据库连接对象
     * @param sql    SQL语句
     * @param params 参数
     * @return 影响表中数据的条数
     * @throws SQLException SQL执行异常
     */
    public int update(Connection conn, String sql, Object... params) throws SQLException {
        QueryRunner r = new QueryRunner();
        return r.update(conn, sql, params);
    }

    /**
     * 查询一个集合. 默认在一个事务. <br>
     * 表中的列与实体类的属性名的映射关系为: 下划线命名---驼峰结构
     *
     * @param sql    SQL语句
     * @param clazz  查询数据的结果类型
     * @param params 查询参数
     * @param <T>    查询结果实体类的Class对象
     * @return 结果的集合
     * @throws SQLException SQL执行异常
     */
//    public <T> List<T> queryList(String sql, Class<T> clazz, Object... params) throws SQLException {
//        QueryRunner r = new QueryRunner(ds);
//        return r.query(sql, new BeanListHandler<>(clazz, new HumpProcessor()), params);
//    }

    /**
     * 查询一个集合. 默认不在事务中. <br>
     * 表中的列与实体类的属性名的映射关系为: 下划线命名---驼峰结构
     *
     * @param conn   数据库连接对象
     * @param sql    SQL语句
     * @param clazz  查询数据的结果类型
     * @param params 查询参数
     * @param <T>    查询结果实体类的Class对象
     * @return 结果的集合
     * @throws SQLException SQL执行异常
     */
//    public <T> List<T> queryList(Connection conn, String sql, Class<T> clazz, Object... params) throws SQLException {
//        QueryRunner r = new QueryRunner();
//        return r.query(conn, sql, new BeanListHandler<>(clazz, new HumpProcessor()), params);
//    }

    /**
     * 查询单条数据. 默认在一个事务. <br>
     * 表中的列与实体类的属性名的映射关系为: 下划线命名---驼峰结构
     *
     * @param sql    SQL语句
     * @param clazz  查询数据的结果类型
     * @param params 查询参数
     * @param <T>    查询结果实体类的Class对象
     * @return 结果的集合
     * @throws SQLException SQL执行异常
     */
//    public <T> T queryOne(String sql, Class<T> clazz, Object... params) throws SQLException {
//        QueryRunner r = new QueryRunner(ds);
//        return r.query(sql, new BeanHandler<>(clazz, new HumpProcessor()), params);
//    }

    /**
     * 查询单条数据. 默认不在事务中. <br>
     * 表中的列与实体类的属性名的映射关系为: 下划线命名---驼峰结构
     *
     * @param conn   数据库连接对象
     * @param sql    SQL语句
     * @param clazz  查询数据的结果类型
     * @param params 查询参数
     * @param <T>    查询结果实体类的Class对象
     * @return 结果的集合
     * @throws SQLException SQL执行异常
     */
//    public <T> T queryOne(Connection conn, String sql, Class<T> clazz, Object... params) throws SQLException {
//        QueryRunner r = new QueryRunner();
//        return r.query(conn, sql, new BeanHandler<>(clazz, new HumpProcessor()), params);
//    }

    /**
     * 可以将多个SQL操作放在一个事务中.
     * @param executor SQL多操作的回调接口
     * @return 执行是否成功
     */
//    public boolean execute(MultiSqlExecutor executor) {
//        boolean flag = false;
//        Connection conn = null;
//        try {
//            conn = getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if (conn != null) {
//            try {
//                conn.setAutoCommit(false);
//                QueryRunner runner = new QueryRunner();
//                executor.execute(conn, runner);
//                DbUtils.commitAndCloseQuietly(conn);
//                flag = true;
//            } catch (SQLException e) {
//                e.printStackTrace();
//                DbUtils.rollbackAndCloseQuietly(conn);
//                flag = false;
//            }
//        }
//        return flag;
//    }
}