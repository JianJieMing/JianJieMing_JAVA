package cart.bean;


public class CartBean {
    private int uid, bid, cartCount;

    public CartBean() {
    }

    public CartBean(int uid, int bid, int cartCount) {
        this.uid = uid;
        this.bid = bid;
        this.cartCount = cartCount;
    }

    @Override
    public String toString() {
        return "CartBean{" +
                "uid=" + uid +
                ", bid=" + bid +
                ", cartCount=" + cartCount +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getCartCount() {
        return cartCount;
    }

    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }
}
