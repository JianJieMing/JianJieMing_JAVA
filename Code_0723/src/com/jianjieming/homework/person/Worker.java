package com.jianjieming.homework.person;

import com.jianjieming.homework.function.Goods;
import com.jianjieming.homework.function.GoodsList;
import com.jianjieming.homework.goodscart.GoodsShelf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 工人类
 * 继承职员类
 * 读取商品清单,然后给货架上货.
 *
 * @author 铭
 */
public class Worker extends Staff {
    public boolean readGoodsList(GoodsList list, GoodsShelf goodsShelf) {
        String path = list.getListingPath();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("goods.txt"));
            List<Goods> goodsList = new ArrayList<>();
            String line = null;
            byte[] bytes = new byte[1024];
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                String s = split[0];
                int anInt = Integer.parseInt(s);
                Goods g = new Goods();
                g.setGoodsId(anInt);
                System.out.println(g.getGoodsId());
//
//                g.getGoodsId()
//                int quantity = 0;
//                goodsShelf.addGoods(g,quantity);
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
