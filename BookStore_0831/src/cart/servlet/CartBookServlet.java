package cart.servlet;

import cart.bean.CartBookBean;
import cart.dao.impl.CartDaoImpl;
import user.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 从购物车中查询某个用户的图书信息
 *
 * @author 铭
 * DATE: 18/9/4 下午3:19
 */
@WebServlet(name = "CartBookServlet", urlPatterns = "/cartBook")
public class CartBookServlet extends HttpServlet {

    CartDaoImpl cartDao = new CartDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean user = (UserBean) request.getSession().getAttribute("user");
        int uid = user.getUid();
        List<CartBookBean> list = cartDao.queryBook(uid);
        float allPrice = 0.00F;
        for (CartBookBean bean : list) {
            float price = Float.parseFloat(bean.getPrice());
            int cartCount = bean.getCartCount();
            float sub = price * cartCount;
            allPrice += sub;
        }
        request.setAttribute("bookList", list);
        HttpSession session1 = request.getSession();
        session1.setAttribute("bookList", list);
        session1.setAttribute("allPrice", allPrice);
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request, response);
    }
}
