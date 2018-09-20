package admin.servlet;

import admin.dao.impl.CategoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 修改分类
 *
 * @author 铭
 * DATE: 18/9/3 上午11:11
 */
@WebServlet(name = "UpdateCategoryServlet", urlPatterns = "/updateCategory")
public class UpdateCategoryServlet extends HttpServlet {

    CategoryImpl category = new CategoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String jsp = (String) session.getAttribute("jsp");
        String cname2 = request.getParameter("cname2");
        if (!cname2.equals("") && cname2.length() > 0 && !cname2.trim().equals("")) {
            category.updateClassify(cname2, jsp);
            response.sendRedirect("/adminjsps/admin/category/list.jsp");
        } else {
            String msg;
            msg = "书名不可以为空";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/adminjsps/admin/msg.jsp").forward(request, response);
        }
    }
}
