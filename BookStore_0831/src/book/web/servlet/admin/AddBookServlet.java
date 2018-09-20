package book.web.servlet.admin;

import book.domain.Book;
import book.service.BookService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 上传图片
 * 添加一本书
 */
@WebServlet(name = "AddBookServlet", urlPatterns = "/addBook.do")
public class AddBookServlet extends HttpServlet {

    private BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload up = new ServletFileUpload(factory);
        String realPath = getServletContext().getRealPath("book_img");
        FileUtils.forceMkdir(new File(realPath));
        Book book = new Book();
        HttpSession session = request.getSession();
        try {
            List<FileItem> fileItems = up.parseRequest(request);
            Map<String, String> map = new HashMap<>();
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    String key = fileItem.getFieldName();
                    String value = fileItem.getString("utf-8");
                    map.put(key, value);
                } else {
                    if ("image".equals(fileItem.getFieldName())) {
                        if (fileItem.getContentType().startsWith("image")) {
                            String name = fileItem.getName();
                            String substring = name.substring(name.lastIndexOf(".") + 1);
                            // 后缀名
                            String type = "." + substring;
                            //内容类型
                            String imageType = fileItem.getContentType();
                            String uuid = UUID.randomUUID().toString();
                            File file = new File(realPath, uuid + type);
                            fileItem.write(file);
                            String path = file.getAbsolutePath();
                            book.setImage("book_img/" + (uuid + type));
                        }
                    }
                }
            }
            book.setBname(map.get("bname"));
            book.setPrice(Double.parseDouble(map.get("price")));
            book.setAuthor(map.get("author"));
            book.setCid(map.get("cid"));
            bookService.add(book);
            session.setAttribute("book", book);
            String msg;
            msg = "添加成功";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/adminjsps/admin/msg.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
