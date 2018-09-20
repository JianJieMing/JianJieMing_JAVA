package Test01.equipment;

import Test01.base.GoodsContaine;
import Test01.entity.Goods;
import Test01.exception.GoodsCartFullException;

/**
 * 商品车基类
 * 继承货物类
 *
 * @author 铭
 */
public abstract class GoodsCart extends GoodsContaine {

    private int remainSize;
    private String cartName;

    public GoodsCart() {
        remainSize = maxSize();
        cartName = getCartName();
    }


    @Override
    public void addGoods(Goods goods, int quantity) {
        if (remainSize >= quantity) {
            cells.add(new GoodsCell(goods, quantity));
            remainSize -= quantity;
        } else {
            throw new GoodsCartFullException(cartName);
        }
    }

    //    为收银员类提供了一个计算money的方法
    public float compute() {
        float money = 0;
        for (GoodsCell cell : cells) {
            money += cell.getGoods().getPrice() * cell.getQuantity();
        }
        return money;
    }

    public abstract int maxSize();

    public abstract String getCartName();
}
