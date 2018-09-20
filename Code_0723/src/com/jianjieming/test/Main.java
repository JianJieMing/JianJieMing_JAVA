package com.jianjieming.test;

import java.io.FileNotFoundException;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            工人 读取商品清单,然后给货架上货
            清单类 俩属性: 清单名称 清单路径
            货架类 存储商品和商品数量,   货架的名称,和清单同名

            顾客: 方法 选择货架(查看货架上有什么商品).
                 可以根据商品的id和数量添加到购物车中.
                 有个结账方法,参数有个收银员.
                 有名字
            购物车: 添加商品
                三个子类: 没有购物车 只能5件
                         篮子 10件
                         车  50件
            收银员 由顾客选择一个收银员,然后收银员获取顾客的购物车,放入收银台结算.有名字
            收银台 结算功能,打折功能.

            货架购物车有一个父类
            收银员和工人和顾客有一个父类
         */
    }
}
