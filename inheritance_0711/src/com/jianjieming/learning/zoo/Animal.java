package com.jianjieming.learning.zoo;

/**
 * 动物类
 *
 * @author 铭
 */
public class Animal {
    public static final int AAA = 5;

    /**
     * 重写父类Object类的equals方法
     * 重新定义两个对象是否相等的规则
     *
     * @return
     */
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        判断obj对象是不是Animal类型的.
//        if (obj instanceof Animal) {
//            Animal other = (Animal) obj;
//            return this.name.equals(other.name) && this.id == other.id;
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (id != animal.id) return false;
        return name != null ? name.equals(animal.name) : animal.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    /**
     * 重写Object类的toString()方法
     * 返回该对象的所有属性
     *
     * @return
     */
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Animal{").append("name = ").append(name).append(", id = ").append(id).append("}");
//        return sb.toString();
//    }
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }



    /*
        如果父类的属性是private,那么子类无法直接调用,
    但是可以通过父类的set&get方法间接的使用该属性.

            在创建一个对象的时候,调用构造方法时,
    一定会先调用父类的构造方法.

            在java中如果没有明确指定父类类型,那么它就继承Object类.

            java中类是单继承的.也就是说一个类同时只能直接继承一个类.
     */

//    public Animal() {
//    }

    public Animal(String name, int id) {
        this.name = name;
        this.id = id;
    }

    private String name;

    private int id;

    public void eat() {
        System.out.println(name + "正在吃");
    }

    public void sleep() {
        System.out.println(name + "正在睡觉");
    }

    public void introduction() {
        System.out.println("大家好,我是" + id + "号,我就是风流潇洒的" + name);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}
