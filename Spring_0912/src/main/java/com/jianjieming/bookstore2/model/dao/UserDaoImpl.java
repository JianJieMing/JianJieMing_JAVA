package com.jianjieming.bookstore2.model.dao;

import com.jianjieming.bookstore2.model.vo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午3:11
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User("钱电" + i);
            users.add(user);
        }
        return users;
    }
}
