package com.lanou3g;

import java.io.*;

public class Demo  {
    public static void main(String[] args) throws Exception {
        //其他的流
        FileOutputStream fos = new FileOutputStream("object.txt");
        //对象输出流可以向流中写入对象
        //完成数据的持久化
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Goods g = new Goods();
        g.setName("大苹果");
        g.setPrice(10);

        oos.writeObject(g);

        oos.close();
        fos.close();
    }
}
