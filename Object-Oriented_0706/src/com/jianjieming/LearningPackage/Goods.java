package com.jianjieming.LearningPackage;

public class Goods {
    private String name;
    private float price;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Goods(String name, float price) {
        this.name = name;
        this.price = price;
    }

    void print() {
        System.out.println("商品名称: " + name + "       " + "商品单价" + price);
    }
}
