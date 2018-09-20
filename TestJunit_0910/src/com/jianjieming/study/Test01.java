package com.jianjieming.study;

import org.junit.Test;

/**
 * @author 铭
 * DATE: 18/9/10 上午9:49
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println("test main");
        Test01 test = new Test01();
        test.test();
    }

    @Test
    public void test() {
        System.out.println("Hello junit");
    }
}
