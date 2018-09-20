package com.jianjieming.bookstore.model.dao;

import com.jianjieming.bookstore.model.vo.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 上午11:45
 */
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> selectAll() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("多重影分身" + i, 1 + i);
            books.add(book);
        }
        return books;
    }
}
