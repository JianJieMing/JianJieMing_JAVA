package com.lanou3g;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BufferedDemo {
    public static void main(String[] args) throws Exception {
        //带缓冲的流
        //数据流的转换
//        InputStream is = new FileInputStream("Goods.txt");
        //把一个字节流转换成字符流
//        InputStreamReader reader = new InputStreamReader(is);
        //字符流可以转换为处理效率更高的BufferReader
        //BufferReader 带缓冲的字符流
        //特点:读文本文件的时候可以一次读一行
        FileReader r = new FileReader("Goods.txt");
        BufferedReader br = new BufferedReader(r);
        List<Goods> goodsList = new ArrayList<>();
        String line = "";
        while ((line=br.readLine())!=null){
            //一行一行的读,在解析
            String[] split = line.split(",");
            String name = split[0];
            int price = Integer.parseInt(split[1]);
            Goods goods = new Goods();
            goods.setName(name);
            goods.setPrice(price);
            goodsList.add(goods);

        }
        br.close();
        r.close();
        System.out.println(goodsList);

        System.out.println("==============================");
        //装饰者模式
        FileWriter fileWriter = new FileWriter("Text.txt");
        BufferedWriter bw = new BufferedWriter(fileWriter);

        bw.write("abcdefg");
        bw.write("dsfewatarew");
        bw.write("cxzpvkp");
        bw.write("😝");
        //手动冲一下
//
        bw.write("😄");
        bw.write("🙄");
        bw.write("😒");
//        bw.flush();
        bw.close();
    }
}
