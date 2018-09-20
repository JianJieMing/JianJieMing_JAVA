package orders.bean;

import java.util.Date;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/5 上午8:52
 */
public class OrdersBean {
    private float allprice;
    private Date ordertime;
    private int  uid, state;
    private String address,oid;
    private List<OrderItem> orderItems;

    public OrdersBean() {
    }

    public OrdersBean(float allprice, Date ordertime, int uid, int state, String address, String oid, List<OrderItem> orderItems) {
        this.allprice = allprice;
        this.ordertime = ordertime;
        this.uid = uid;
        this.state = state;
        this.address = address;
        this.oid = oid;
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "OrdersBean{" +
                "allprice=" + allprice +
                ", ordertime=" + ordertime +
                ", uid=" + uid +
                ", state=" + state +
                ", address='" + address + '\'' +
                ", oid='" + oid + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }

    public float getAllprice() {
        return allprice;
    }

    public void setAllprice(float allprice) {
        this.allprice = allprice;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
