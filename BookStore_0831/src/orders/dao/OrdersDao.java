package orders.dao;

import orders.bean.OrderItem;
import orders.bean.OrdersBean;

import java.util.Date;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/5 上午8:49
 */
public interface OrdersDao {

    int insert(String oid, Date ordertime, float allprice, int state, int uid, String address);

    List<OrdersBean> findAll(int uid);

    void insertOrderItem(int count, float subtotal, String oid, int bid);

    List<OrderItem> selectItem(OrdersBean ordersBean);

    List<OrdersBean> adminFindAll();

    List<OrdersBean> adminFindOne(int state);

    void updateOrders (String oid);









}
