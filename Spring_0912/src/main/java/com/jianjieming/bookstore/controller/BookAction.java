package com.jianjieming.bookstore.controller;

import com.jianjieming.bookstore.model.service.BookService;
import com.jianjieming.bookstore.model.vo.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 上午11:37
 */
public class BookAction {

    private BookService service;

    public BookService getService() {
        return service;
    }

    public void setService(BookService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext(3).xml");
        BookAction bookAction = (BookAction) context.getBean("bookAction");
        List<Book> list = bookAction.service.showAll();
        System.out.println(list);
    }
}
