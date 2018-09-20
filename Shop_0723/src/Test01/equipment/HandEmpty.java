package Test01.equipment;

/**
 * 空手
 * 继承商品车
 * @author 铭
 */
public class HandEmpty extends GoodsCart{
//    手可拿的商品数量
    public int maxSize(){
        return 5;
    }
//    提供空手名称
    public String getCartName(){
        return "空手";
    }
}
