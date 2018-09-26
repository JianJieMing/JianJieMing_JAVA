package com.lanou3g.demo.book.dao;

import com.lanou3g.demo.bean.BookBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2018/9/18
 */
@Repository
public class BookDaoImpl implements BookDao{
    @Override
    public List<BookBean> findByPage(String page, String count) {
        sleep(800);
        List<BookBean> bookList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BookBean b = new BookBean();
            b.setId(i + 1);
            b.setName("金鳞岂是池中物" + i);
            b.setAuthor("毕胜鹏" + i);
            bookList.add(b);
        }
        return bookList;
    }

    @Override
    public BookBean addOne(BookBean book) {
        sleep(500);
        return book;
    }

    @Override
    public BookBean removeOne(int id) {
        sleep(200);
        BookBean b = new BookBean();
        b.setId(id);
        b.setName("金瓶梅");
        b.setAuthor("兰陵笑笑生");
        return b;
    }

    public static void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
