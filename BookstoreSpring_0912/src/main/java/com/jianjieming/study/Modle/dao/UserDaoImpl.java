package com.jianjieming.study.Modle.dao;

import com.jianjieming.study.Modle.vo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午4:47
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> queryAll() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User("孙风" + i);
            users.add(user);
        }
        return users;
    }
}
