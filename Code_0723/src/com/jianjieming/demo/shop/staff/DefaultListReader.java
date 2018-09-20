package com.jianjieming.demo.shop.staff;


import com.jianjieming.demo.shop.entity.Goods;
import com.jianjieming.demo.shop.entity.GoodsList;
import com.jianjieming.demo.shop.equipment.GoodsShelf;

import java.io.BufferedReader;
import java.io.FileReader;

public class DefaultListReader implements ListFileReader {
    @Override
    public boolean loadListToShelf(GoodsList list, GoodsShelf shelf) {
        // 获取清单名称
        String listName = list.getName();
        // 将清单名称设置给货架
        shelf.setName(listName);
        // 获取清单文件路径
        String path = list.getPath();

        try (
                FileReader r = new FileReader(path);
                BufferedReader br = new BufferedReader(r)
        ) {
            String line = null;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                // 解析读取到的字符串
                Goods g = new Goods();
                // 商品id
                g.setId(Integer.parseInt(data[0]));
                // 商品名称
                g.setName(data[1]);
                // 商品价格
                g.setPrice(Float.parseFloat(data[2]));
                // 货物数量
                int quantity = Integer.parseInt(data[3]);
                // 计量单位
                g.setUnit(data[4]);
                // 将商品和数量添加到货架
                shelf.addGoods(g, quantity);
            }
            // 如果没有出现异常, 返回true, 证明货物上架成功
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            // 出现任意异常都认为货物上架失败, 返回false
            return false;
        }
    }
}
