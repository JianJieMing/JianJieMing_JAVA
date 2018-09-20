package Test01.equipment;

import Test01.base.GoodsContaine;
import Test01.entity.Goods;

/**
 * 货架
 * 继承货物
 *
 * @author 铭
 */
public class GoodsShelf extends GoodsContaine {
    //    货架名称
    private String name;

    /**
     * 重写父类的添加货物方法
     *
     * @param goods    需要向商品容器中添加的商品
     * @param quantity 商品的数量
     */
    @Override
    public void addGoods(Goods goods, int quantity) {
        GoodsCell cell = new GoodsCell(goods, quantity);
        cells.add(cell);
    }

    /**
     * 打印该货架上的商品信息
     */
    public void print() {
        System.out.println("该货物的名称为: " + name);
        System.out.println("商品清单如下: ");
        System.out.println("商品id\t商品名称\t商品价格\t\t商品数量");
        for (GoodsCell cell : cells) {
            Goods g = cell.getGoods();
            System.out.printf("%s\t%s\t%s元/%s\t%s%s\n", g.getId(), g.getName(), g.getPrice(), g.getUnit(), cell.getQuantity(), g.getUnit());
        }
    }

    /**
     * 货架名称属性的set方法
     *
     * @param name 货架名称
     */
    public void setName(String name) {
        this.name = name;
    }

    public Goods remove(int goodsId, int quantity) {
        GoodsCell cell = null;
        for (GoodsCell c : cells) {
            if (goodsId == c.getGoods().getId()) {
                cell = c;
                break;
            }
        }
        if (cell != null && cell.getQuantity() >= quantity) {
            cell.setQuantity(cell.getQuantity() - quantity);
            return cell.getGoods();
        }
        return null;
    }
}
