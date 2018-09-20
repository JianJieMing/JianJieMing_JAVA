package cart.servlet;

import cart.dao.impl.CartDaoImpl;
import user.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 清空购物车
 *
 * @author 铭
 * DATE: 18/9/4 下午8:56
 */
@WebServlet(name = "EmptyCartServlet", urlPatterns = "/emptyCart")
public class EmptyCartServlet extends HttpServlet {

    CartDaoImpl cartDao = new CartDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean user = (UserBean) request.getSession().getAttribute("user");
        int uid = user.getUid();
        cartDao.emptyCart(uid);
        response.sendRedirect("/cartBook");
    }
}
