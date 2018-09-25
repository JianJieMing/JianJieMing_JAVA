package com.jianjieming.homework.service;

import com.jianjieming.homework.bean.UserBean;
import com.jianjieming.homework.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 铭
 * 2018/9/25 10:24
 */
@Service
public class UserService {
    @Resource
    private UserDaoImpl userDao;

    public List<UserBean> showAll() {
        List<UserBean> userBeans = userDao.queryUser();
        if (userBeans != null) {
            return userBeans;
        }
        return null;
    }

}
