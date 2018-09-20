//package order.web.servlet;
//
//import book.domain.Book;
//import cart.domain.Cart;
//import cart.domain.CartItem;
//import com.lanou.commons.CommonUtils;
//import order.domain.Order;
//import order.domain.OrderItem;
//import order.service.OrderService;
//import unit.BaseServlet;
//import user.domain.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//@WebServlet(name = "OrderServlet", urlPatterns = "/order")
//public class OrderServlet extends BaseServlet {
//    private OrderService orderService = new OrderService();
//
//   private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            Order order = new Order();
//            Cart cart = (Cart) request.getSession().getAttribute("cart");
//            Map<String, CartItem> cartItems = cart.getCartItemMap();
//            Set<String> bids = cartItems.keySet();
//            List<OrderItem> orderItemList = new ArrayList<>();
//            for (String bid : bids) {
//                OrderItem orderItem = new OrderItem();
//                CartItem cartItem = cartItems.get(bid);
//                int count = cartItem.getCount();
//                Book book1 = cartItem.getBook();
//                orderItem.setCount(count);
//                orderItem.setSubtotal(count * book1.getPrice());
//                orderItem.setOid(CommonUtils.uuid());
//                orderItem.setBid(book1.getBid());
//                orderItem.setBook(book1);
//                orderItemList.add(orderItem);
//            }
//            User user = (User) request.getSession().getAttribute("user");
//            String sumMoney1 = request.getParameter("sumMoney");
//            Double sumMoney = Double.valueOf(sumMoney1);
//            Date date = new Date();
//            SimpleDateFormat simpleDateFormat =
//                    new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            order.setOid(CommonUtils.uuid());
//            order.setOrdertime(simpleDateFormat.format(date));
//            order.setTotal(sumMoney);
//            order.setUid(user.getUid());
//            //地址先不写
//            order.setAddress("");
//            order.setOrderItems(orderItemList);
//            orderService.add(order);
//            request.setAttribute("order", order);
//            cartItems.clear();
//            request.getRequestDispatcher("/jsps/order/desc.jsp")
//                    .forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void orders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        User user = (User) request.getSession().getAttribute("user");
//        List<Order> orders = orderService.findAll(user.getUid());
//        request.setAttribute("orders", orders);
//        request.getRequestDispatcher("/jsps/order/list.jsp").forward(request, response);
//    }
//}
