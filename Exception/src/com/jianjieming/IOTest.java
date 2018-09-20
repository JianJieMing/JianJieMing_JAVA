package com.jianjieming;

import java.io.IOException;

/**
 * @author 铭
 */
public class IOTest {

    public void test(int age) throws Exception {
        if (age < 0) {
            throw new IOException();
        }
        if (age < 10){
            throw new NoSuchFieldException();
        }
    }

}
