package com.jianjieming.homework.dao;

import com.jianjieming.homework.bean.UserBean;

import java.util.List;

public interface UserDao {
    List<UserBean> queryUser();
}
