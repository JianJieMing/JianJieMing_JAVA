package book.web.servlet;

import book.domain.Book;
import book.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改一本书的信息
 */
@WebServlet(name = "ModServlet", urlPatterns = "/mod")
public class ModServlet extends HttpServlet {

    private BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        int bid = Integer.parseInt(request.getParameter("bid"));
        String bname = request.getParameter("bname");
        double price = Double.parseDouble(request.getParameter("price"));
        String author = request.getParameter("author");
        String image = request.getParameter("image");
        String cid = request.getParameter("cid");
        book.setBid(bid);
        book.setBname(bname);
        book.setPrice(price);
        book.setAuthor(author);
        book.setImage(image);
        book.setCid(cid);
        bookService.mod(book);
        String msg;
        msg = "修改成功";
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/adminjsps/admin/msg.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
