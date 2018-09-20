package com.jianjieming.demo.shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Goods> goodsList;
    private int index;

    public ShoppingCart() {
        goodsList = new ArrayList<>();
    }

    public void add(Goods goods) {
        goodsList.add(goods);
//        if (index >= goodsList.size()) {
//            Goods[] newArr = new Goods[goodsArr.length << 1];
//            for (int i = 0; i < goodsArr.length; i++) {
//                newArr[i] = goodsArr[i];
//            }
//            goodsArr = newArr;
//        }
//        goodsArr[index++] = goods;
    }

    public float totalMoney() {
        float sum = 0;
        for (Goods g : goodsList) {
            if (g != null) {
                sum += g.getPrice();
            }
        }
//        for (int i = 0; i < index; i++) {
//            sum += goodsArr[i].getPrice();
//        }
        return sum;
    }

//    public List<Goods> getGoodsArr() {
//        return goodsList;
//    }

    public int size() {
        return index;
    }

}
