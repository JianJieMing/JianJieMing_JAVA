package cart.servlet;

import cart.bean.CartBean;
import cart.dao.impl.CartDaoImpl;
import user.bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加购物车
 * 更新购物车数量
 * 不登录无法使用购物车
 *
 * @author 铭
 * DATE: 18/9/4 上午11:53
 */
@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    CartDaoImpl cartDao = new CartDaoImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean user = (UserBean) request.getSession().getAttribute("user");
        // 判断用户是否登录,没登录不能购买
        if (user != null) {
            int uid = user.getUid();
            int bid = Integer.parseInt(request.getParameter("bid"));
            int count = Integer.parseInt(request.getParameter("count"));
            // 查询某个用户的购物车中的所有信息
            CartBean queryCart = cartDao.queryCart(uid, bid);
            if (queryCart != null) {
                int bid1 = queryCart.getBid();
                if (bid1 == bid) {
                    int count1 = queryCart.getCartCount();
                    int i = count1 + count;
                    // 购物车有相同的书,只更新数量
                    cartDao.updateCount(i, uid, bid1);
                } else {
                    // 添加购物车
                    cartDao.insert(bid, count, uid);
                }
            } else {
                // 添加购物车
                cartDao.insert(bid, count, uid);
            }
            request.getRequestDispatcher("/cartBook").forward(request, response);
        } else {
            String msg;
            msg = "请先登录";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/adminjsps/admin/msg.jsp").forward(request, response);
        }
    }
}
