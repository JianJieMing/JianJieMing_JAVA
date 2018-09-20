package orders.servlet;

import orders.bean.OrdersBean;
import orders.dao.impl.OrdersDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminFindAllServlet", urlPatterns = "/adminFindAll")
public class AdminFindAllServlet extends HttpServlet {
    private OrdersDaoImpl ordersDao = new OrdersDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrdersBean> orders = ordersDao.adminFindAll();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/adminjsps/admin/order/text.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
