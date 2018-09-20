package user.dao;

import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import user.bean.UserBean;

import java.sql.SQLException;

public class UserDao {
    GxQueryRunner runner = new GxQueryRunner();

    public UserBean login(String username) throws SQLException {
        String sql = "select * from USER where username=?";
        UserBean user = runner.query(sql, new BeanHandler<>(UserBean.class), username);
        return user;
    }

    public void regist(UserBean user) throws SQLException {
        String sql = "insert into USER(username,password,email,code) value(?,?,?,?) ";
        Object[] o = {user.getUsername(), user.getPassword(), user.getEmail(), user.getPassword()};
        runner.update(sql, o);
    }
}