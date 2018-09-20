package cart.bean;


// 用于接收查询的购物车表单

public class CartBookBean {
    private String bname, price, author, image;
    private int bid, cartCount;

    public CartBookBean() {
    }

    public CartBookBean(String bname, String price, String author, String image, int bid, int cartCount) {
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.image = image;
        this.bid = bid;
        this.cartCount = cartCount;
    }

    @Override
    public String toString() {
        return "CartBookBean{" +
                "bname='" + bname + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", bid=" + bid +
                ", cartCount=" + cartCount +
                '}';
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
