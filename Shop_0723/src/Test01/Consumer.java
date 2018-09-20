package Test01;

import Test01.base.Person;
import Test01.entity.Goods;
import Test01.equipment.GoodsCart;
import Test01.equipment.GoodsShelf;
import Test01.staff.Cashier;

/**
 * 顾客类
 * 继承人类
 *
 * @author 铭
 */
public class Consumer extends Person {
    //    顾客选择的购物车对象
    private GoodsCart cart;
    //    顾客当前查看的货架对象
    private GoodsShelf shelf;

    /**
     * 选择购物车对象
     *
     * @param cart 购物车对象
     */
    public void selectGoodsCart(GoodsCart cart) {
        this.cart = cart;
    }

    /**
     * 选择查看的货架对象
     * @param shelf 货架对象
     */
    public void selectShelf(GoodsShelf shelf) {
        this.shelf = shelf;
//        选择了货架之后打印出货架上的商品信息
        shelf.print();
    }

    /**
     * 根据打印出的商品id购买商品及数量
     *
     * @param goodsId  商品id
     * @param quantity 商品数量
     */
    public void buy(int goodsId, int quantity) {
        if (cart == null) {
            return;
        }
        if (shelf == null) {
            return;
        }
        Goods g = shelf.remove(goodsId, quantity);
        if (g != null) {
            cart.addGoods(g, quantity);
        }
    }

    //    调用收银员的方法,付钱
    public void checkout(Cashier cashier) {
        float money = cashier.check(cart);
        System.out.println("总花费: " + money + "元");
    }
}
