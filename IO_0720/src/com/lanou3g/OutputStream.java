package com.lanou3g;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {

    public static void main(String[] args) {
        //输出字节流
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("AA.txt");
            String str = "锄禾日当午";
            fos.write(str.getBytes());
//            int a = 0;
//            byte[] bytes = new byte[20];
//            while ((a = fis.read(bytes))!=-1){
//                String date = new String(bytes,0,a);
//                System.out.println(date);
//            }


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
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
