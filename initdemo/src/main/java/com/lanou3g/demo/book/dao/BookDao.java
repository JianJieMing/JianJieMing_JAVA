package com.lanou3g.demo.book.dao;

import com.lanou3g.demo.bean.BookBean;

import java.awt.print.Book;
import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
public interface BookDao {

    List<BookBean> findByPage(String page, String count);

    BookBean addOne(BookBean book);

    BookBean removeOne(int id);

}
