package com.jianjieming.bookstore.model.service;

import com.jianjieming.bookstore.model.dao.BookDao;
import com.jianjieming.bookstore.model.vo.Book;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 上午11:36
 */
public class BookService {

    private BookDao dao;

    public BookDao getDao() {
        return dao;
    }

    public void setDao(BookDao dao) {
        this.dao = dao;
    }

    public List<Book> showAll() {
        return dao.selectAll();
    }
}
