package book.service;

import book.dao.BookDao;
import book.dao.impl.BookDaoImpl;
import book.domain.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {

    private BookDao bookDao = new BookDaoImpl();

    public void add(Book book){
        try {
            bookDao.addBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> findAll(){
        try {
            List<Book> books = bookDao.FindAll();
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Book findOne(int bid){
        try {
            Book book = bookDao.findOne(bid);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> findCategory (String cid) throws SQLException {
        List<Book> books = bookDao.findCategory(cid);
        return books;
    }

    public void delOne(int bid){
        try {
            bookDao.delOne(bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void mod(Book book){
        try {
            bookDao.mod(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
