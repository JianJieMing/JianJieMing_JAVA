package orders.dao.impl;

import book.bean.BookBean;
import com.lanou.jdbc.GxQueryRunner;
import orders.bean.OrderItem;
import orders.bean.OrdersBean;
import orders.dao.OrdersDao;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/5 上午9:02
 */
public class OrdersDaoImpl implements OrdersDao {

    GxQueryRunner runner = new GxQueryRunner();

    @Override
    public int insert(String oid, Date ordertime, float allprice, int state, int uid, String address) {
        try {
            String sql = "insert into orders (oid,ordertime,allprice,state,uid,address) values (?,?,?,?,?,?)";
            int update = runner.update(sql, oid, ordertime, allprice, state, uid, address);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<OrdersBean> findAll(int uid) {
        try {
            String sql = "select * from orders where uid = ?";
            List<OrdersBean> orders = runner.query(sql, new BeanListHandler<>(OrdersBean.class), uid);
            for (OrdersBean order : orders) {
                List<OrderItem> orderItems = selectItem(order);
                order.setOrderItems(orderItems);
                for (OrderItem orderItem : orderItems) {
                    String sql2 = "select * from book where bid = ?";
                    BookBean book = runner.query(sql2, new BeanHandler<>(BookBean.class), orderItem.getBid());
                    orderItem.setBook(book);
                }
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderItem> selectItem(OrdersBean ordersBean) {
        System.out.println(ordersBean.getOid());
        String sql = "select * from orderitem where oid= ?";
        List<OrderItem> orderItems = null;
        try {
            orderItems = runner.query(
                    sql,
                    new BeanListHandler<>(OrderItem.class),
                    ordersBean.getOid()
            );
            return orderItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertOrderItem(int count, float subtotal, String oid, int bid) {
        String sql = "insert into orderitem (COUNT,subtotal,oid,bid) values (?,?,?,?)";
        try {
            runner.update(sql, count, subtotal, oid, bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //管理员查询所有订单
    public List<OrdersBean> adminFindAll() {
        String sql = "select * from orders";
        List<OrdersBean> orders = null;
        try {
            orders = runner.query(sql, new BeanListHandler<>(OrdersBean.class));
            hehe(orders);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //管理员查询各状态订单
    public List<OrdersBean> adminFindOne(int state) {
        String sql = "select * from orders where state = ?";
        List<OrdersBean> orders = null;
        try {
            orders = runner.query(sql, new BeanListHandler<>(OrdersBean.class), state);
            hehe(orders);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateOrders(String oid) {
        String sql = "update orders set state = 4 where oid = ?";
        try {
            runner.update(sql,oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void hehe(List<OrdersBean> orders) throws SQLException {
        for (OrdersBean order : orders) {
            List<OrderItem> orderItems = selectItem(order);
            order.setOrderItems(orderItems);
            for (OrderItem orderItem : orderItems) {
                String sql2 = "select * from book where bid = ?";
                BookBean book = runner.query(sql2, new BeanHandler<BookBean>(
                        BookBean.class
                ), orderItem.getBid());
                orderItem.setBook(book);
            }
        }
    }
}
