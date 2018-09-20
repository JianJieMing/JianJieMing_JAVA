package Test01.staff;

import Test01.equipment.GoodsCart;

/**
 * 收银员
 * 继承职业类
 * @author 铭
 */
public class Cashier {
//    计算购物车商品总价
    public float check(GoodsCart cart){
        float money = cart.compute();
        return money;
    }
}
