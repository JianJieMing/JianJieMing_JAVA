package com.lanou3g.demo.book.service;

import com.lanou3g.demo.bean.BookBean;

import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
public interface IBookService {

    List<BookBean> findByPage(String page, String count) throws Exception;

    BookBean addOne(BookBean book);

    BookBean remove(int id);

}
