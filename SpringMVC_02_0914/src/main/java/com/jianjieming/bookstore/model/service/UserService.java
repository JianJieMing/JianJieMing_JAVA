package com.jianjieming.bookstore.model.service;

import com.jianjieming.bookstore.model.dao.UserDaoImpl;
import com.jianjieming.bookstore.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/14 下午2:40
 */
@Service
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

    public List<User> showAll() {
        if (userDao != null) {
            List<User> users = userDao.queryAll();
            return users;
        } else {
            System.out.println("没有用户");
        }
        return null;
    }


}
