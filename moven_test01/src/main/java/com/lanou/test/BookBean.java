package com.lanou.test;

/**
 * @author 铭
 * DATE: 18/9/10 上午11:46
 */
public class BookBean {
    private int bid,cid;
    private float price;
    private String bname,author,image;

    public BookBean() {
    }

    public BookBean(int bid, int cid, float price, String bname, String author, String image) {
        this.bid = bid;
        this.cid = cid;
        this.price = price;
        this.bname = bname;
        this.author = author;
        this.image = image;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "bid=" + bid +
                ", cid=" + cid +
                ", price=" + price +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
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
}
