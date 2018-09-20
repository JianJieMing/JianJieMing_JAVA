package com.jianjieming.bookstore.model.dao;

import com.jianjieming.bookstore.model.vo.User;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午3:10
 */
public interface UserDao {
    List<User> selectAll();
}
