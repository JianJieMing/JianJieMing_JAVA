package com.jianjieming.bookstore.model.dao;

import com.jianjieming.bookstore.model.vo.User;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/14 下午2:35
 */
public interface UserDao {

    List<User> queryAll();

}
