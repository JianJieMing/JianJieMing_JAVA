package book.servlet;

import book.bean.BookBean;
import book.dao.impl.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询所有书
 * 查询某个类别的书
 *
 * @author 铭
 * DATE: 18/9/3 上午11:57
 */
@WebServlet(name = " BookCategoryServlet", urlPatterns = "/bookCategory")
public class BookCategoryServlet extends HttpServlet {

    BookDaoImpl bookDao = new BookDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        List<BookBean> bookBeans;
        if (cid.equals("all")) {
            bookBeans = bookDao.queryAllBook();
        } else {
            bookBeans = bookDao.queryCategoryBook(cid);
        }
        request.setAttribute("bookBeans", bookBeans);
        request.getRequestDispatcher("/jsps/book/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
