package Test01.equipment;

/**
 * 篮子
 * 继承商品车
 *
 * @author 铭
 */
public class GoodsBasket extends GoodsCart {
//    篮子可装商品的数量
    public int maxSize() {
        return 10;
    }
//    提供篮子的名称
    public String getCartName() {
        return "篮子";
    }
}
