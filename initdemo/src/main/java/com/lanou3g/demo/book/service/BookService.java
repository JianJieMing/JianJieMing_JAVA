package com.lanou3g.demo.book.service;

import com.lanou3g.demo.bean.BookBean;
import com.lanou3g.demo.book.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
@Service
public class BookService implements IBookService {

    @Resource
    private BookDao bookDao;

    @Override
    public List<BookBean> findByPage(String page, String count) throws Exception {
        int i = Integer.parseInt(page);
        if (i < 1) throw new IllegalArgumentException("传递页数page不能小于0");
        int c = Integer.parseInt(count);
        if (c < 1) throw new IllegalArgumentException("数量不能小于1");

        return bookDao.findByPage(page, count);
    }

    @Override
    public BookBean addOne(BookBean book) {
        return bookDao.addOne(book);
    }

    @Override
    public BookBean remove(int id) {
        return bookDao.removeOne(id);
    }
}
