package com.jianjieming.bookstore2.controller;

import com.jianjieming.bookstore2.model.service.BookService;
import com.jianjieming.bookstore2.model.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 上午11:37
 */
@Controller
// BookAction bookAction = new BookAction();
public class BookAction {
    @Autowired
    private BookService service;

    public BookService getService() {
        return service;
    }

    public void setService(BookService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext(5).xml");
        BookAction bookAction = (BookAction) context.getBean("bookAction");
        List<Book> list = bookAction.service.showAll();
        System.out.println(list);
    }
}
