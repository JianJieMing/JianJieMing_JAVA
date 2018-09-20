package com.jianjieming;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        /*
            异常
         */
        NullPointerException n = new NullPointerException("狗贼");
//        获取一个信息.
//        System.out.println(n.getMessage());
        System.out.println("*************");
//        在控制台打印该异常的日志
//        n.printStackTrace();
//        System.out.println("+++++++++++++");
//        throw n;

//        Object o = new Object();
//        Main m = (Main) o;

        /*
            异常的处理
         */

        Object o = null;
        try {
            System.out.println("START");
            System.out.println(5 / 9);
            System.out.println(o.toString());
            System.out.println("END");
        } catch (NullPointerException e) {
            System.out.println("出现了空指针");
            e.printStackTrace();
            e.getMessage();
        } catch (ArithmeticException e2) {
            System.out.println("算数异常");
        } finally {

        }
        System.out.println("测试程序是否执行完成");

        div(-1, 5);


//        强制检查型异常
        IOTest ioTest = new IOTest();
        try {
            ioTest.test(6);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }




    private static int div(int x, int y) {
//        规定: 该方法只能计算两个正整数的除法.
        if (x <= 0 || y <= 0) {
            throw new 不能是负数傻逼("只能传正整数二货    " + x + "     " + y + "     没点逼数吗");
        }
        return x / y;
    }


}
