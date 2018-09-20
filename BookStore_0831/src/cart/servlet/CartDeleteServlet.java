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
 * 从购物车中删除图书
 * @author 铭
 * DATE: 18/9/4 下午8:13
 */
@WebServlet(name = "CartDeleteServlet", urlPatterns = "/cartDelete")
public class CartDeleteServlet extends HttpServlet {

    CartDaoImpl cartDao = new CartDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean user = (UserBean) request.getSession().getAttribute("user");
        int uid = user.getUid();
        int bid = Integer.parseInt(request.getParameter("delBid"));
        cartDao.deleteBook(bid, uid);
        response.sendRedirect("/cartBook");
    }
}
