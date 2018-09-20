package com.jianjieming.demo.iterable;

import com.jianjieming.demo.shop.Goods;

/**
 * @author 铭
 */
public interface MyIterator {

//    用来判断是否有下一个
    boolean hasNext();

//    获取下一个元素
    Goods next();


}
