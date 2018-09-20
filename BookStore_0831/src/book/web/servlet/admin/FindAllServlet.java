package book.web.servlet.admin;

import book.domain.Book;
import book.service.BookService;
import category.domain.Category;
import category.service.CategoryService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import unit.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 查询所有的书
 */
@WebServlet(urlPatterns = "/findAll.do")
public class FindAllServlet extends BaseServlet {
    private BookService bookService = new BookService();
    private CategoryService categoryService = new CategoryService();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/adminjsps/admin/book/list.jsp").forward(request, response);
    }

    public void delOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookService.delOne(Integer.parseInt("bid"));
        request.getRequestDispatcher("adminjsps/admin/book/desc.jsp").forward(request, response);
    }


    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bid = request.getParameter("bid");
        Book book = bookService.findOne(Integer.parseInt(bid));
        request.setAttribute("book", book);
        List<category.domain.Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/adminjsps/admin/book/desc.jsp").forward(request, response);
    }

    public void findbook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bid = request.getParameter("bid");
        Book book = bookService.findOne(Integer.parseInt(bid));
        request.setAttribute("book", book);
        request.getRequestDispatcher("/jsps/book/desc.jsp").forward(request, response);
    }

    public void showCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = null;
        try {
            categoryList = categoryService.findAll();
            request.setAttribute("categoryList", categoryList);
            request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Book book = (Book) session.getAttribute("book");
        ServletOutputStream out = response.getOutputStream();
        String imagePath = book.getImage();
        byte[] bytes = FileUtils.readFileToByteArray(new File(imagePath));
        IOUtils.write(bytes, out);
        out.close();
    }
}
