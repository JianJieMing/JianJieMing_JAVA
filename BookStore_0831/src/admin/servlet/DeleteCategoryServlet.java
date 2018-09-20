package admin.servlet;

import admin.dao.impl.CategoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除分类
 * @author 铭
 * DATE: 18/9/3 上午11:21
 */
@WebServlet(name = "DeleteCategoryServlet", urlPatterns = "/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {

    CategoryImpl category = new CategoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname22");
        category.deleteClassify(cname);
        response.sendRedirect("/adminjsps/admin/category/list.jsp");

    }
}
