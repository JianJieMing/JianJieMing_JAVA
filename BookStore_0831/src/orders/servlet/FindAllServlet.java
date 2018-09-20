package orders.servlet;

import order.domain.OrderItem;
import orders.bean.OrdersBean;
import orders.dao.impl.OrdersDaoImpl;
import user.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllServlet", urlPatterns = "/findAll")
public class FindAllServlet extends HttpServlet {
    private OrdersDaoImpl ordersDao = new OrdersDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean user = (UserBean) request.getSession().getAttribute("user");
        int uid = user.getUid();
        System.out.println(uid+"UID");
        List<OrdersBean> orders = null;
        List<OrderItem> orderItems = null;
        orders = ordersDao.findAll(uid);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/jsps/order/list.jsp").forward(request, response);
    }
}
