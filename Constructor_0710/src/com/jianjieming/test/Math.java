package com.jianjieming.test;

/**
 * 数学类
 *
 * @author 铭
 */
public class Math {
    public static int abs(int n) {
        return n > 0 ? n : -n;

        /*

            方法的递归:
                在方法的内部,还调用自己.

            阶乘 f(n) = n x f(n-1) f(0) = 1

            f(n) = f(n - 1) + f(n - 2)
            f(0) = 1
            f(1) = 1

         */

    }

    public static int diss(int n) {
        if (n == 0) return 1;
        else return n * diss(n - 1);
    }

    public static int fi(int n){
        if (n == 0) return 1;
        if (n == 1) return 1;
        return fi(n - 1) + fi(n - 2);
    }


}
