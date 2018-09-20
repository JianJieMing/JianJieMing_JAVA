package com.jianjieming.test;

import java.io.FileInputStream;

/**
 * @author 铭
 */
public class Test03 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("goods.txt")) {
            int index = 0;
            byte[] bytes = new byte[1024];
            while ((index = fis.read(bytes)) != -1) {
                String data = new String(bytes, 0, index);
                System.out.println(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
