package com.jianjieming.demo.shop;

public class CashierDesk {

    private ShoppingCart shoppingCart;
    private Discountable discountable;

    public CashierDesk(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        discountable = new DefaultDiscount();
    }

    public float checkout(){
        float totalMoney = shoppingCart.totalMoney();
        return discountable.discount(totalMoney);
    }

    public void setDiscountable(Discountable discountable) {
        this.discountable = discountable;
    }

    //    public float checkout(){
//        Goods[] goodsArr = shoppingCart.getGoodsArr();
//        float sum = 0;
//        for (Goods g : goodsArr) {
//            if (g != null){
//                sum += g.getPrice();
//            }
//        }
//        return sum;
//    }

}
