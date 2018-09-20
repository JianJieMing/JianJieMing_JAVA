package com.jianjieming.demo.shop;


import com.jianjieming.demo.shop.base.Person;
import com.jianjieming.demo.shop.entity.Goods;
import com.jianjieming.demo.shop.equipment.GoodsCart;
import com.jianjieming.demo.shop.equipment.GoodsShelf;
import com.jianjieming.demo.shop.staff.Cashier;

/**
 * 顾客类
 */
public class Consumer extends Person {

    /** 顾客选择的购物车对象 */
    private GoodsCart cart;
    /** 顾客当前查看的货架对象 */
    private GoodsShelf shelf;

    /**
     * 选择购物车对象
     * @param cart 购物车对象
     */
    public void selectGoodsCart(GoodsCart cart){
        this.cart = cart;
        // TODO: 2018/7/23 输出顾客xxx选择了xxx购物车
    }

    /**
     * 选择查看的货架对象
     * @param shelf 货架对象
     */
    public void selectShelf(GoodsShelf shelf){
        this.shelf = shelf;
        // 选择了货架之后打印出货架上的商品信息
        shelf.print();
    }

    /**
     * 根据打印出的商品id购买商品及数量
     * @param goodsId 商品id
     * @param quantity 商品数量
     */
    public void buy(int goodsId, int quantity){
        if (cart == null) {
            // TODO: 2018/7/23 输出, 买东西之前请先选择购物车
            return;
        }
        if (shelf == null) {
            // TODO: 2018/7/23
            return;
        }
        // TODO: 2018/7/23 顾客买商品的过程就是从货架上移除商品
        Goods g = shelf.remove(goodsId, quantity);
        if (g != null) {
            cart.addGoods(g, quantity);
        }
    }

    public void checkout(Cashier cashier){
        float money = cashier.check(cart);
        System.out.println("总共花费: " + money + "元");
    }


}
