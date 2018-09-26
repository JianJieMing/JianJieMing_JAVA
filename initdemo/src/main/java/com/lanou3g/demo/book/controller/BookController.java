package com.lanou3g.demo.book.controller;

import com.lanou3g.demo.bean.BookBean;
import com.lanou3g.demo.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    private IBookService bookService;

    @RequestMapping("/{path}")
    public String bookPage(@PathVariable String path){
        return path;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<BookBean> findBooks(
            @RequestParam(defaultValue = "1") String page,
            @RequestParam(defaultValue = "20") String count){
        try {
            List<BookBean> list = bookService.findByPage(page, count);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            return null;
        }
    }

    @RequestMapping(value = "/addOne", method = RequestMethod.POST)
    @ResponseBody
    public BookBean add(BookBean book){
        return bookService.addOne(book);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public BookBean remove(int id){
        return bookService.remove(id);
    }







}
