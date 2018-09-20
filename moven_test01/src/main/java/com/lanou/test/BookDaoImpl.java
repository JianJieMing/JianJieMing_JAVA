package com.lanou.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/10 上午11:48
 */
public class BookDaoImpl implements BookDao {
    private static final String URL = "jdbc:mysql://localhost:3306/MyBookstore";
    private static final String USER = "root";
    private static final String WORD = "123456";

    @Override
    public List<BookBean> bookList() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, WORD);
            Statement statement = conn.createStatement();
            String sql = "select * from book";
            ResultSet resultSet = statement.executeQuery(sql);
            List<BookBean> bookBeans = new ArrayList<>();
            while (resultSet.next()) {
                BookBean bookBean = new BookBean();
                int bid = resultSet.getInt("bid");
                String bname = resultSet.getString("bname");
                float price = resultSet.getFloat("price");
                String author = resultSet.getString("author");
                String image = resultSet.getString("image");
                int cid = resultSet.getInt("cid");
                bookBean.setBid(bid);
                bookBean.setBname(bname);
                bookBean.setPrice(price);
                bookBean.setAuthor(author);
                bookBean.setImage(image);
                bookBean.setCid(cid);
                bookBeans.add(bookBean);
            }
            return bookBeans;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
