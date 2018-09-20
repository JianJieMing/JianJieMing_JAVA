package com.jianjieming.demo.shop.equipment;


import com.jianjieming.demo.shop.base.GoodsContainer;
import com.jianjieming.demo.shop.entity.Goods;

/**
 * 货架类
 */
public class GoodsShelf extends GoodsContainer {

    /** 货架名称 */
    private String name;

    /**
     * 重写父类的添加货物方法
     * @param goods 需要向商品容器中添加的商品
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
    public void print(){
        System.out.println("该货架的名称为: " + name);
        System.out.println("商品清单如下: ");
        System.out.println("商品id\t商品名称\t商品价格\t\t商品数量");
        for (GoodsCell cell : cells) {
            Goods g = cell.getGoods();
            System.out.printf("%s\t%s\t%s元/%s\t%s%s\n", g.getId(), g.getName(), g.getPrice(), g.getUnit(), cell.getQuantity(), g.getUnit());
        }
    }

    /**
     * 货架名称属性的setter方法
     * @param name 货架名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 根据商品id从货架上移除对应数量的商品
     * @param goodsId 商品id
     * @param quantity 需要移除的货物数量
     * @return 从货架中移除的商品对象, 如果移除失败则返回null
     */
    public Goods remove(int goodsId, int quantity) {
        GoodsCell cell = null;
        // 找到货架上商品id为goodsId的商品
        for (GoodsCell c : cells) {
            if (goodsId == c.getGoods().getId()){
                cell = c;
                break;
            }
        }
        // 如果找到该商品并且商品数量大于等于需要移除的数量
        if (cell != null && cell.getQuantity() >= quantity){
            // 货架上的商品数量减掉quantity个
            cell.setQuantity(cell.getQuantity() - quantity);
            // 返回商品id为goodsId的商品对象
            return cell.getGoods();
        }
        // 如果找不到商品则返回null
        return null;
    }
}
