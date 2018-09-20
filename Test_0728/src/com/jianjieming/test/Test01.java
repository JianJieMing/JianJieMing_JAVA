package com.jianjieming.test;

import com.jianjieming.test.entity.Goods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author 铭
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("goods.txt"));
        FileWriter fw = new FileWriter("goods.txt",true);
        String line = "";
        String s2 = "\n牛奶,6";
        String s3 = "\n香蕉,9";
        fw.write(s2);
        fw.write(s3);
        fw.close();
        while ((line = br.readLine()) != null) {
            Goods goods = new Goods();
            String[] split = line.split(",");
            String s = split[0];
            String s1 = split[1];
            goods.setName(s);
            goods.setPrice(Float.parseFloat(s1));
            System.out.println("商品名称: " + goods.getName() + "\t商品价格" + goods.getPrice());
        }
    }
}
