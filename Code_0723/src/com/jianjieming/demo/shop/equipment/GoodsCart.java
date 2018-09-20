package com.jianjieming.demo.shop.equipment;

import com.jianjieming.demo.shop.base.GoodsContainer;
import com.jianjieming.demo.shop.entity.Goods;
import com.jianjieming.demo.shop.exception.GoodsCartFullException;

/**
 * 购物车的基类
 */
public abstract class GoodsCart extends GoodsContainer {

    private int remainSize;
    private String cartName;

    public GoodsCart() {
        remainSize = maxSize();
        cartName = getCartName();
    }

    @Override
    public void addGoods(Goods goods, int quantity) {
        if (remainSize >= quantity){
            cells.add(new GoodsCell(goods, quantity));
            remainSize -= quantity;
        } else {
            // 货物如果装满了就抛出个异常
            throw new GoodsCartFullException(cartName);
        }
    }

    public float compute(){
        float money = 0;
        for (GoodsCell cell : cells) {
            money += cell.getGoods().getPrice() * cell.getQuantity();
        }
        return money;
    }

    public abstract int maxSize();
    public abstract String getCartName();
}
