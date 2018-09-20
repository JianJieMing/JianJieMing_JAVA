package com.jianjieming.study.Modle.service;

import com.jianjieming.study.Modle.dao.UserDaoImpl;
import com.jianjieming.study.Modle.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午4:50
 */
@Service
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

    public List<User> showAll() {
        return userDao.queryAll();
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                '}';
    }


}
