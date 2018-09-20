package order.dao;

import book.domain.Book;
import com.lanou.commons.CommonUtils;
import com.lanou.jdbc.GxQueryRunner;
import order.domain.Order;
import order.domain.OrderItem;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDao {

    //查询这个用户的所有订单
    public List<Order> selectAll(int uid) throws SQLException {
        String sql = "select * from orders where uid = ?";
        GxQueryRunner runner = new GxQueryRunner();
        List<Order> orders = runner.query(sql, new BeanListHandler<>(Order.class), uid);
        return orders;
    }
    //添加订单
    public void addOrder(Order order) throws SQLException {
        String sql = "insert into orders values (?, ?, ?, ?, ?)";
        GxQueryRunner runner = new GxQueryRunner();
        Object [] o ={order.getOid(),order.getOrdertime(),order.getTotal(),order.getUid(),order.getAddress()};
        runner.update(sql,o);
    }

    //添加订单中的书
    public void addOrderItem(List<OrderItem> orderItemList) throws SQLException {
        for (OrderItem orderItem : orderItemList) {
            String sql = "insert into orderitem values (?, ?, ?, ?, ?)";
            GxQueryRunner runner = new GxQueryRunner();
            Object [] o = {orderItem.getCount(),orderItem.getSubtotal(),orderItem.getOid(),orderItem.getBid()};
            runner.update(sql,o);
        }
    }

    public Order load(String oid) throws SQLException {
        String sql = "select * from orders where oid=?";
        GxQueryRunner runner = new GxQueryRunner();
        Order order = runner.query(sql, new BeanHandler<>(Order.class), oid);
        selectItem(order);
        return order;
    }

    //查询商品的所有信息
    public void selectItem(Order order) throws SQLException {
        String sql = "select * from orderitem,book where orderitem.bid=book.bid and oid= ?";
        GxQueryRunner runner = new GxQueryRunner();
        List<Map<String, Object>> query = runner.query(sql, new MapListHandler(), order.getOid());
        List<OrderItem> orderItems = toOrderItemList(query);
        order.setOrderItems(orderItems);
    }

    private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        for (Map<String, Object> map : mapList) {
            OrderItem item = toOrderItem(map);
            orderItemList.add(item);
        }
        return orderItemList;
    }

    private OrderItem toOrderItem(Map<String, Object> map) {
        OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
        Book book = CommonUtils.toBean(map, Book.class);
        orderItem.setBook(book);
        return orderItem;

    }




}
