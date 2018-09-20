package com.jianjieming.demo.shop.staff;

import com.jianjieming.demo.shop.base.Staff;
import com.jianjieming.demo.shop.entity.GoodsList;
import com.jianjieming.demo.shop.equipment.GoodsShelf;

/**
 * 工人类, 功能为读取清单信息为货架上货
 */
public class Worker extends Staff {

    private ListFileReader reader;

    public Worker() {
        reader = new DefaultListReader();
    }

    /**
     * 读取清单信息, 为货架上货
     * @param list 需要读取的清单信息
     * @param shelf 货架对象
     * @return 上货是否成功
     */
    public boolean loadListToShelf(GoodsList list, GoodsShelf shelf) {
        System.out.println(getName() + "开始上货:");
        return reader.loadListToShelf(list, shelf);
    }

    public void setListFileReader(ListFileReader reader){
        this.reader = reader;
    }

}
