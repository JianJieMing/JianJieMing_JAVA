package book.dao;


import book.bean.BookBean;
import book.domain.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/3 上午11:45
 */
public interface BookDao {

    // 查询所有的书
    List<BookBean> queryAllBook();

    // 查询指定类别的书
    List<BookBean> queryCategoryBook(String cid);

    // 查询书的详细信息
    List<BookBean> bookMessage(String bid);

    // 添加一本书
    void addBook(Book book) throws SQLException;

    // 查询所有的书
    List<Book> FindAll() throws SQLException;

    // 查询一本书
    Book findOne(int bid) throws SQLException;

    // 查询某个类别的书
    List<Book> findCategory(String cid) throws SQLException;

    // 删除一本书
    void delOne(int bid) throws SQLException;

    // 修改一本书的信息
    void mod(Book book) throws SQLException;

}
