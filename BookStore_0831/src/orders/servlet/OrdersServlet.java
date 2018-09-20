package orders.servlet;

import cart.bean.CartBookBean;
import cart.dao.impl.CartDaoImpl;
import orders.dao.impl.OrdersDaoImpl;
import user.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/5 上午9:39
 */
@WebServlet(name = "OrdersServlet", urlPatterns = "/orders")
public class OrdersServlet extends HttpServlet {

    private OrdersDaoImpl ordersDao = new OrdersDaoImpl();
    private CartDaoImpl cartDao = new CartDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserBean user = (UserBean) request.getSession().getAttribute("user");
        int uid = user.getUid();

        int state = Integer.parseInt(request.getParameter("state"));
        String address = request.getParameter("address");
        String date = request.getParameter("format");
        String oid = request.getParameter("oid");
        System.out.println(date + "转换前");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        HttpSession session1 = request.getSession();
        List<CartBookBean> bookList = (List<CartBookBean>) session1.getAttribute("bookList");
        float price = 0;
        for (CartBookBean bean : bookList) {
            int count = bean.getCartCount();
            float unit = Float.parseFloat(bean.getPrice());
            // 小计的价格
            float money = unit * count;
            int bid = bean.getBid();
            // 总价
            price += money;
            ordersDao.insertOrderItem(count, money, oid, bid);
        }
        try {
            Date date1 = sdf.parse(date);
            int insert = ordersDao.insert(oid, date1, price, state, uid, address);
            if (insert > 0) {
                cartDao.emptyCart(uid);
                response.sendRedirect("/findAll");
            } else {
                String msg;
                msg = "系统异常,请联系客服!";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("/adminjsps/admin/msg.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
