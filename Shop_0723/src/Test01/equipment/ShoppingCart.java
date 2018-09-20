package Test01.equipment;

/**
 * 购物车
 * 继承商品车
 * @author 铭
 */
public class ShoppingCart extends GoodsCart{
    //    购物车可拿的商品数量
    public int maxSize(){
        return 20;
    }
    //    提供购物车名称
    public String getCartName(){
        return "购物车";
    }
}
