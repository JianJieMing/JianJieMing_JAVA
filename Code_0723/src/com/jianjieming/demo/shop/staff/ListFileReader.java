package com.jianjieming.demo.shop.staff;


import com.jianjieming.demo.shop.entity.GoodsList;
import com.jianjieming.demo.shop.equipment.GoodsShelf;

public interface ListFileReader {

    boolean loadListToShelf(GoodsList list, GoodsShelf shelf);

}
