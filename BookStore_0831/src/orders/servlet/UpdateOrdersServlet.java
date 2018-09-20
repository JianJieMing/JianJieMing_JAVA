package orders.servlet;

import orders.dao.impl.OrdersDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/9/7 上午8:53
 */
@WebServlet(name = "UpdateOrdersServlet", urlPatterns = "/updateOrders")
public class UpdateOrdersServlet extends HttpServlet {

    private OrdersDaoImpl ordersDao = new OrdersDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        ordersDao.updateOrders(oid);
        response.sendRedirect("/findAll");
    }
}
