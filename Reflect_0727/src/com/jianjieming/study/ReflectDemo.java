package com.jianjieming.study;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 铭
 */
public class ReflectDemo {
    public static void main(String[] args) {
        Goods g = new Goods();
        g.setName("手机");
        g.setPrice(1999);
        g.setUnit("台");

        /*
            转成Map
            name=手机
            price=1999
            unit=台
         */

        Map<String, Object> map = beanToMap(g);
        System.out.println(map);

    }

    private static Map<String, Object> beanToMap(Object o) {
        /*
            根据对象获取Class对象
            根据Class对象获取所有Field
            遍历Field数组,Field的名字就是Map的Key,值就是Map的value
            组合为键值对的形式放入Map
            返回Map对象
         */
        Map<String, Object> goodsMap = new HashMap<>();
        Class<Goods> goodsClass = Goods.class;
        Field[] declaredFields = goodsClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String name = declaredField.getName();
            try {
                Object o1 = declaredField.get(o);
                goodsMap.put(name, o1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return goodsMap;

    }

    public static class Goods {
        private String name;
        private float price;
        private String unit;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }
}
