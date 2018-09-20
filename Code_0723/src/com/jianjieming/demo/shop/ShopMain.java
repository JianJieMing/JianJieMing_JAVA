package com.jianjieming.demo.shop;

import com.jianjieming.demo.shop.entity.GoodsList;
import com.jianjieming.demo.shop.equipment.GoodsBasket;
import com.jianjieming.demo.shop.equipment.GoodsCart;
import com.jianjieming.demo.shop.equipment.GoodsShelf;
import com.jianjieming.demo.shop.equipment.HandEmpty;
import com.jianjieming.demo.shop.exception.GoodsCartFullException;
import com.jianjieming.demo.shop.staff.Cashier;
import com.jianjieming.demo.shop.staff.Worker;

public class ShopMain {

    public static void main(String[] args) {

        GoodsShelf snackShelf = new GoodsShelf();
        GoodsList snackList = new GoodsList("零食", "goods.txt");
        Worker worker = new Worker();
        worker.setName("高帅儿");
        Cashier cashier = new Cashier();

        GoodsCart hand = new HandEmpty();
        GoodsCart basket = new GoodsBasket();

        Consumer consumer = new Consumer();

        boolean b = worker.loadListToShelf(snackList, snackShelf);
        if (b) {
            consumer.selectGoodsCart(basket);
            consumer.selectShelf(snackShelf);
            try{
                consumer.buy(10002, 5);
                consumer.buy(10008, 8);
            }catch (GoodsCartFullException e){
                String message = e.getMessage();
                System.out.println(message);
            }
            consumer.checkout(cashier);


            snackShelf.print();
        }


    }
}
