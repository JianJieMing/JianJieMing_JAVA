package com.jianjieming.bookstore.model.service;

import com.jianjieming.bookstore.model.dao.UserDao;
import com.jianjieming.bookstore.model.vo.User;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午3:13
 */
public class UserService {
    private UserDao userDao;

    public List<User> showAll() {
        return userDao.selectAll();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
