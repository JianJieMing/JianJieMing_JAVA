package com.jianjieming.test;

/**
 * @author 铭
 */
public class Goods {

    /**
     * snacks : {"id":10001,"name":"甜辣鸭脖","price":12.9,"number":0,"unit":"袋"}
     * number : 10
     */

    private SnacksBean snacks;
    private int number;

    public SnacksBean getSnacks() {
        return snacks;
    }

    public void setSnacks(SnacksBean snacks) {
        this.snacks = snacks;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static class SnacksBean {


        private int id;
        private String name;
        private double price;
        private int number;
        private String unit;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }
}
