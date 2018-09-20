package com.jianjieming.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 铭
 */
public class Test02 {
    public static void main(String[] args) {
        String s1 = "/Users/dllo/Desktop/未命名.rtf";
        String s2 = "/Users/dllo/Desktop/未命21312名.rtf";


        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            new FileInputStream(s1);
            new FileOutputStream(s2);

            byte[] bytes = new byte[1024*1024];
            int a = 0;
            while ((a = fis.read(bytes)) != -1) {
                fos.write(bytes,0,a);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
