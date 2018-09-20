package user.service;

import user.bean.UserBean;
import user.dao.UserDao;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao = new UserDao();

    public UserBean login(UserBean user) throws SQLException {
        UserBean user1 = userDao.login(user.getUsername());
        if (user1==null){
            //登陆失败
            return null;
        }else if (user1.getPassword().equals(user.getPassword())){
            //登陆成功
            return user1;
        }
        return null;
    }

    public String regist(UserBean user) throws SQLException {
        UserBean user1 = userDao.login(user.getUsername());
        if (user1 != null) {
            return "用户名已被注册";
        }
        userDao.regist(user);
        return null;
    }
}
