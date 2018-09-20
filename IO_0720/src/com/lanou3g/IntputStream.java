package com.lanou3g;

import java.io.FileInputStream;

public class IntputStream {
    public static void main(String[] args) {
        //字节输入流
        //这种写法,会自动对数据流进行close
        try(FileInputStream fis = new FileInputStream("AA.txt")) {
            byte[] bytes = new byte[20];
            int a = 0;
//            fis.read(bytes);
//            String s = new String(bytes);
            while ((a = fis.read(bytes))!=-1){
                String data = new String(bytes,0,a);
                System.out.println(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
