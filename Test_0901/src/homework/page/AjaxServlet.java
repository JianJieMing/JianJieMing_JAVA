package homework.page;

import com.google.gson.Gson;
import homework.bean.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/9/1 下午1:26
 */
@WebServlet(name = "AjaxServlet", urlPatterns = "/ajax")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");

        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        Page page = gson.fromJson(reader, Page.class);
        int page1 = page.getPage();
        int count = page.getCount();
        request.setAttribute("page", page1);
        request.setAttribute("count", count);
        System.out.println(page1);
        System.out.println("*******");
        System.out.println(count);
        request.getRequestDispatcher("/ajax2").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
