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
 * 查询一本书的详细信息
 *
 * @author 铭
 * DATE: 18/9/4 上午10:36
 */
@WebServlet(name = "BookMessageServlet", urlPatterns = "/bookMessage")
public class BookMessageServlet extends HttpServlet {

    BookDaoImpl bookDao = new BookDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        List<BookBean> bookMessage = bookDao.bookMessage(bid);
        request.setAttribute("bookMessage", bookMessage);
        request.getRequestDispatcher("/jsps/book/desc.jsp").forward(request, response);
    }
}
