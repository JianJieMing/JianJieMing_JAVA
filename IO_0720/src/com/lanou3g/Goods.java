package com.lanou3g;

import java.io.Serializable;

public class Goods implements Serializable {

    private String name;
    //transient  加上这个关键字,就不会写到流中了
    private transient int price;

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}'+'\n';
    }

    public String getName() {
        return name;
    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Goods setPrice(int price) {
        this.price = price;
        return this;
    }
}
