package com.jianjieming.homework;

public class Main {
    public static void main(String[] args) {

        /**
         * 创建顾客对象
         */
        Consumer consumer1 = new Consumer();
        consumer1.name = "张三";
        consumer1.age = 15;
        /**
         * 创建商品对象
         */
        Goods goods1 = new Goods();
        goods1.goodsname = "苹果";
        goods1.goodsprice = 6666.66F;

        Goods goods2 = new Goods();
        goods2.goodsname = "小米";
        goods2.goodsprice = 3100.00F;

        Goods goods3 = new Goods();
        goods3.goodsname = "努比亚";
        goods3.goodsprice = 3199.00F;

        consumer1.goShopping(goods1);
        consumer1.goShopping(goods2);
        consumer1.goShopping(goods3);
        consumer1.goShopping(goods3);
        consumer1.goShopping(goods3);
        consumer1.goShopping(goods3);
        consumer1.buy();

        System.out.println("**********");
        CashierDesk cashierDesk = new CashierDesk();
        cashierDesk.dz1();
        cashierDesk.dz2();
        cashierDesk.dz3();
        consumer1.empty();
    }
}
