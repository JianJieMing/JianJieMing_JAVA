package com.jianjieming.study.Modle.dao;

import com.jianjieming.study.Modle.vo.User;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午4:47
 */
public interface UserDao {
    List<User> queryAll();
}
