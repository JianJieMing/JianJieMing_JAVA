package com.jianjieming.bookstore2.model.service;

import com.jianjieming.bookstore2.model.dao.BookDao;
import com.jianjieming.bookstore2.model.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 上午11:36
 */
@Service
public class BookService {
    @Autowired
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
