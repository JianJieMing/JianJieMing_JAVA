package com.lanou3g;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {

        //文件字符输入流
        //用来读取文本文件中的内容

        FileReader reader = null;
        try {
            reader = new FileReader("Text.txt");
//            //一次读一个字符
//            int c = reader.read();
//            while (c != -1) {
//                System.out.println((char) c);
//                c = reader.read();
//            }

            //一次读多个字符
            char[] chars = new char[8];

//            //将输入流中字符读取到字符数组中
//            //返回值代表读出字符的数量
//            int read = reader.read(chars);
//            //数组转字符串
//            String str = new String(chars,0,read);
//            System.out.println(str);

//            int length = reader.read(chars);
//            while (length != -1) {
//                String str = new String(chars,0,length);
//                System.out.println(str);
//                length = reader.read(chars);
//            }

            int length = 0;
            while ((length = reader.read(chars))!=-1){
                String str = new String(chars,0,length);
                System.out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
