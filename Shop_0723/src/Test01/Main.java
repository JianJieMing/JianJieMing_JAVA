package Test01;

import Test01.entity.GoodsList;
import Test01.equipment.*;
import Test01.exception.GoodsCartFullException;
import Test01.staff.Cashier;
import Test01.staff.Worker;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
//        创建一个零食货架
        GoodsShelf snackShelf = new GoodsShelf();
//        创建商品清单
        GoodsList snackList = new GoodsList();
//        创建工人
        Worker worker = new Worker();
//        为工人设置名字
        worker.setName("泠鸢");
//        创建收银员
        Cashier cashier = new Cashier();
//        购物车一号
        GoodsCart cart1 = new HandEmpty();
//        购物车二号
        GoodsCart cart2 = new GoodsBasket();
//        购物车三号
        GoodsCart cart3 = new ShoppingCart();
//        创建顾客
        Consumer consumer = new Consumer();
//        工人将解析出来的商品信息上架到商品清单和货架上
        boolean b = worker.store(snackList, snackShelf);
        if (b) {
//            顾客选择购物车
            consumer.selectGoodsCart(cart2);
//            顾客选择货架
            consumer.selectShelf(snackShelf);
            try {
                consumer.buy(10002, 5);
                consumer.buy(10008, 8);
            } catch (GoodsCartFullException e) {
                String message = e.getMessage();
                System.out.println(message);
            }
            consumer.checkout(cashier);


            snackShelf.print();
        }

        System.out.println("******************");

    }
}
