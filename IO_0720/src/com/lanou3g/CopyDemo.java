package com.lanou3g;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) {
        //使用字节流实现文件的复制

        //原文件的路径
        String srcPath = "/Users/dllo/Desktop/AA.txt/p.jpg";
        //目的文件
        String desPath = "/Users/dllo/Desktop/BB.txt/j.jpg";

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(desPath);
            byte[] bytes = new byte[1024 * 1024];
            int length = 0;
            //把输入流中的数据放入数组,
            //并判断是否放完
            while ((length = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, length);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
