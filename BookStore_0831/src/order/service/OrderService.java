package order.service;

import order.dao.OrderDao;
import order.domain.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderDao orderDao = new OrderDao();

    public void add(Order order) throws SQLException {
        orderDao.addOrder(order);
        orderDao.addOrderItem(order.getOrderItems());
    }

    public List<Order> findAll(int uid) throws SQLException {
        List<Order> orders = orderDao.selectAll(uid);
        return orders;
    }

    public Order loaad(String oid) throws SQLException {
        Order order = orderDao.load(oid);
        return order;
    }



}
