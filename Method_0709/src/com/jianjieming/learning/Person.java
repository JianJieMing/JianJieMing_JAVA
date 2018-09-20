package com.jianjieming.learning;

/**
 * 人类
 *
 * @author 铭
 */
public class Person {
    private String name;
    private int age;

    /*
        set 方法存在的意义:
            1. 把属性的修改过程移动到当前的类中,
               这样当前的类就保有了该属性的修改权限,
               可以方便的对其进行控制,防止属性被非法修改.
            2. 可以分别对某个属性的读写权限进行控制.
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            this.age = 0;
        }
        if (age > 150) {
            System.out.print("不是人");
        }
        if (age > 0 && age < 100) {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /*
        如果某个方法的返回值类型为void,
        那么在方法体中也可以写return,但是后面不能有值.

        在某个方法中遇到了return,那么会直接结束该方法.

        如果该return不是必要的,则可以省略.
     */


    /*

        方法的重载 Overload:
            在同一个类中,多个方法的方法名相同,但是参数列表不一样(类型/数量/顺序,不一样),
            这些方法的关系叫做重载.

     */

    public void eat() {
//        System.out.println("吃东西");
        eat("东西");
    }

    public void eat(String food) {
        System.out.println("吃" + food);
    }

    public void eat(String food, int times) {
        for (int i = 0; i < times; i++) {
            eat(food);
        }
    }

    public void eat(int tiems,String food){

    }


}
