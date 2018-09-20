package com.jianjieming.demo;


import com.jianjieming.demo.shop.Goods;
import com.jianjieming.demo.shop.ShoppingCart;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        Goods g1 = new Goods(1, "商品1", 10);
//        Goods g2 = new Goods(2, "商品2", 20);
//        Goods g3 = new Goods(3, "商品3", 30);
//        Goods g4 = new Goods(4, "商品4", 40);

        ShoppingCart cart = new ShoppingCart();
//        cart.add(g1);
//        cart.add(g2);
//        cart.add(g3);
//        cart.add(g4);

//        CashierDesk desk = new CashierDesk(cart);
//        desk.setDiscountable(new EightDiscount());
//        System.out.println(desk.checkout());
//
//        List collection = new ArrayList();
//        collection.add(1);
//        collection.add(g1);
//        collection.add("哈哈哈");
//        System.out.println(collection.size());
//        Object o = collection.get(0);

        /*
            用的最多的情况,就是集合中放的都是同一种数据类型的对象.
            使用泛型
         */

//        龟腚集合中可以存放的数据类型.
        List<Goods> list = new LinkedList<>();
//        list.add(1);  只能放Goods对象
//        list.add(g1);
//        list.add(g1);
//        list.add(g1);
//        list.add(g2);
//        list.add(g2);
//        根据下边获取数据.
//        Goods goods = list.get(1);
//        list.remove(g2); // 把某个元素从集合中移除.
//        list.remove(1); // 根据下标移除集合中的某个元素.
//        System.out.println(list.size()); // 获取集合中元素的数量.

        /*
            ArrayList 内部使用数组实现的,查找效率非常高,因为内存是连续的,
            当删除或插入某个元素的时候,其他大部分元素都会发生移动,所以效率比较低.

            LinkedList 内部使用链表实现,查找某个元素的时候,只能从开始位置遍历,所以效率比较低.
            但是插入和删除某个元素的时候,其他元素不用移动位置,效率比较高.
         */

//        判断集合中有没有g1这个对象.
//        Boolean b = list.contains(g1);
//        清空集合
//        list.clear();
//        判断某个元素在集合中下标.
//        int i = list.indexOf(g1); // -1
//        判断集合是不是空的.
//        boolean empty = list.isEmpty();
//
//        Goods[] goodses = list.toArray(new Goods[list.size()]);
//
//        List<Goods> list2 = list.subList(0, 3);
//        list2.remove(1);
//        System.out.println("原集合长度:" + list.size());

//        集合的遍历

//        1. for循环
//        for (int i1 = 0; i1 < list.size(); i1++) {
//            Goods goods1 = list.get(i);
//            移除商品价格为10的商品
//            if (goods1.getPrice() == 10F) {
//                list.remove(goods1);
//                i--;
//            }
//        }

         /*
            打印出在集合中商品价格在30--50之间的商品名称.
         */

        list.clear();
        list.add(new Goods(4, "商品1", 22));
        list.add(new Goods(6, "商品2", 11));
        list.add(new Goods(2, "商品3", 44));
        list.add(new Goods(3, "商品4", 20));
        list.add(new Goods(1, "商品5", 18));
        list.add(new Goods(5, "商品6", 42));
        list.add(new Goods(9, "商品7", 5));
        list.add(new Goods(8, "商品8", 55));
        list.add(new Goods(2, "商品9", 36));


        Collections.sort(list, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getId() != o2.getId()) {
                    return o1.getId() - o2.getId();
                }
                return o1.getPrice() - o2.getPrice() > 0 ? 1 : -1;
            }
        });


//        2. 增强for循环
//              在循环中不能更改集合的长度.
//        前提: 集合中的元素一定是可以比较大小的,
//             实现了Comparable接口的类可以自定义比较规则.
//        Collections.sort(list);
        for (Goods goods1 : list) {
            if (goods1.getPrice() >= 30 && goods1.getPrice() <= 50) {
                System.out.println(goods1.getName());
            }
        }

//        list.sort(new Comparator<Goods>() {
//            @Override
//            public int compare(Goods o1, Goods o2) {
//                return 0;
//            }
//        });


//        3. 使用迭代器
//        Iterator<Goods> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Goods next = iterator.next();
//        }

//        4. java8 之后的
//        list.forEach(new Consumer<Goods>() {
//            @Override
//            public void accept(Goods goods) {
//
//            }
//        });

//        4. java8 lambda表达式
//        list.forEach(goods1 -> {
//        });
//
//        List<Integer> list1 = new ArrayList<>();
//        Integer i1 = new Integer(2);
//        list1.add(i1);
//        list1.add(4);
//        list1.add(6);
//        list1.add(8);
//        list1.remove(i1);
//        System.out.println(list1);

//        java8 中的集合处理
//        遍历过滤里面的元素,true往下走.
        System.out.println("java8 处理");
//        找出符合条件的数据并根据id排序,获取商品名称的集合.
//        函数式编程
        List<String> names = list.stream()
//                过滤
                .filter(goods -> goods.getPrice() >= 20 && goods.getPrice() <= 50)
//                排序
                .sorted((o1, o2) -> o1.getId() - o2.getId())
//                类型转换
                .map(goods -> goods.getName())
//                转成集合(有返回值)
                .collect(Collectors.toList());
        System.out.println(names);
//                .forEach(goods -> System.out.println(goods));

    }
}
