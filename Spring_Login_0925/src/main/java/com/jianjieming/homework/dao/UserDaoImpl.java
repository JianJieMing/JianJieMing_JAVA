package com.jianjieming.homework.dao;

import com.jianjieming.homework.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * 2018/9/25 10:15
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<UserBean> queryUser() {
        List<UserBean> userBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserBean user = new UserBean();
            user.setUsername("白虎神皇" + i);
            user.setPassword("111111"+i);
            userBeans.add(user);
        }
        return userBeans;
    }
}
