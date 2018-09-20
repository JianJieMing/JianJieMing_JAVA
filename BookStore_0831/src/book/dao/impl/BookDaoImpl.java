package book.dao.impl;

import book.bean.BookBean;
import book.dao.BookDao;
import book.domain.Book;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/3 上午11:49
 */
public class BookDaoImpl implements BookDao {

    GxQueryRunner runner = new GxQueryRunner();

    /**
     * 查询所有的书籍
     *
     * @return
     */
    @Override
    public List<BookBean> queryAllBook() {
        try {
            String sql = "select * from book";
            List<BookBean> bookBeanList = runner.query(sql, new BeanListHandler<>(BookBean.class));
            return bookBeanList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询某个类别的书
     *
     * @param cid
     * @return
     */
    @Override
    public List<BookBean> queryCategoryBook(String cid) {
        try {
            String sql = "select * from book where cid = ?";
            List<BookBean> query = runner.query(sql, new BeanListHandler<>(BookBean.class), cid);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查看一本书的详细信息
     *
     * @param bid
     * @return
     */
    @Override
    public List<BookBean> bookMessage(String bid) {
        String sql = "select * from book where bid = ?";
        try {
            List<BookBean> bookBeanList = runner.query(sql, new BeanListHandler<>(BookBean.class), bid);
            return bookBeanList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加一本书
     *
     * @param book
     * @throws SQLException
     */
    public void addBook(Book book) throws SQLException {
        String insertImg = "insert into book( bname, price, author, image, cid) values ( ?, ?, ?, ?, ?)";
        Object[] o = {book.getBname(), book.getPrice(), book.getAuthor(), book.getImage(), book.getCid()};
        runner.update(insertImg, o);
    }

    /**
     * 查询所有的书
     *
     * @return
     * @throws SQLException
     */
    public List<Book> FindAll() throws SQLException {
        String sql = "select * from book";
        List<Book> query = runner.query(sql, new BeanListHandler<>(Book.class));
        return query;
    }

    /**
     * 查询一本书
     *
     * @param bid
     * @return
     * @throws SQLException
     */
    public Book findOne(int bid) throws SQLException {
        String sql = "select * from book where bid = ?";
        Book book = runner.query(sql, new BeanHandler<>(Book.class), bid);
        return book;
    }

    /**
     * 查询某个类别的书
     *
     * @param cid
     * @return
     * @throws SQLException
     */
    public List<Book> findCategory(String cid) throws SQLException {
        String sql = "select * from book where cid = ?";
        List<Book> books = runner.query(sql, new BeanListHandler<>(Book.class), cid);
        return books;
    }

    /**
     * 删除一本书
     *
     * @param bid
     * @throws SQLException
     */
    public void delOne(int bid) throws SQLException {
        String sql = "delete from book where bid = ?";
        Object[] o = {bid};
        runner.update(sql, o);
    }

    /**
     * 修改一本书的信息
     *
     * @param book
     * @throws SQLException
     */
    public void mod(Book book) throws SQLException {
        String sql = "update book set bname = ?, price = ?," +
                " author = ?, cid = ? where bid = ?";
        Object[] o = {book.getBname(), book.getPrice(), book.getAuthor(), book.getCid(), book.getBid()};
        runner.update(sql, o);
    }
}
