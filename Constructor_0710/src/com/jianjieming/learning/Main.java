package com.jianjieming.learning;

import com.jianjieming.learning.shopping.Goods;
import com.jianjieming.test.Math;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*

            创建对象的公式:
                类名 对象名 = new 类名();
            实际上是:
                类名 对象名 = new 构造方法;

         */

        Goods phone = new Goods("手机", 1999F);
        Goods clothes = new Goods("衣服", 280F);
//        phone.index = 10;
//        clothes.index = 30;

//        static修饰的变量,被所有对象共享.一个对象改了,其他都变了.
        Goods.index = 10;
        Goods.index = 30;
        System.out.println(Goods.index);



//        phone.name = "手机";
//        phone.price = 1999F;

        /*

           static修饰的方法,可以通过类名.调用.

           方法的构成:
                0个或多个修饰符 返回值类型 方法名 (参数列表) {
                            方法体;
                }


           原因:

           static 静态的
           当创建一个对象的时候,实际上,系统会先加载类,然后才会创建对象.创建多个对象时,类只会加载一次.
           被static修饰的属性或方法,属于类,而不属于对象.



           结论:

           1. 所以static修饰的属性或方法,可以直接通过类名调用.
           2. static修饰的变量,被所有对象共享.一个对象改了,其他都变了.
           3. 在static修饰的方法中,只能调用其他的static方法,但是不能调用普通方法.

           什么时候使用静态方法?
           1. 当方法中不需要引用成员变量(全局变量)的时候,这个方法可以声明为静态方法.
           2. 工具方法一般都会声明为静态的.

         */

        int[] arr = {1, 3, 5, 2, 4};
        System.out.println(Arrays.toString(arr));

        int num = -100;
        int abs = Math.abs(num);
        System.out.println(abs);

        int result = Math.diss(3);
        System.out.println(result);

        int result2 = Math.diss(5);
        System.out.println(result2);
    }
}
