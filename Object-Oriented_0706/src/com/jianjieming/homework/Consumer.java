package com.jianjieming.homework;

import java.util.Scanner;

/**
 * 顾客类
 *
 * @author 铭
 */
public class Consumer {
    public String name; // 顾客名称
    public int age; // 顾客年龄
    public Goods[] shopping = new Goods[1]; // 顾客的购物车
    public int index;
    public static float num;

    Scanner scanner = new Scanner(System.in);


    public void goShopping(Goods goods) {
        if (index < shopping.length) {
            shopping[index] = goods;
            index++;
            if (index == shopping.length) {
                Goods[] newArr = new Goods[shopping.length * 2];
                for (int i = 0; i < shopping.length; i++) {
                    newArr[i] = shopping[i];
                }
                shopping = newArr;
            }
        } else {
            System.out.println("购物车已满," + goods.goodsname + "放入失败.");
        }
    }

    public void buy() {
        System.out.println("顾客名称:" + name);
        for (int i = 0; i < shopping.length; i++) {
            if (shopping[i] != null) {
                num = num + shopping[i].goodsprice;
                shopping[i].myGoods();
            }
        }
        System.out.println("总价格为: " + num);
    }

    public void empty() {
        System.out.println("输入0清空购物车: ");
        int a = scanner.nextInt();
        if (a == 0) {
            Goods[] newArr2 = new Goods[shopping.length];
            shopping = newArr2;
            System.out.println("已清空");
        }
    }

    public float totalMoney() {
        return num;
    }

}
