package com.lanou.test;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BookDaoImpl bookDao = new BookDaoImpl();
        List<BookBean> beans = bookDao.bookList();
        for (BookBean bean : beans) {
            System.out.println(bean);
        }
    }
}
