package com.jianjieming.bookstore2.model.dao;

import com.jianjieming.bookstore2.model.vo.Book;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 上午11:38
 */
public interface BookDao {
    List<Book> selectAll();
}
