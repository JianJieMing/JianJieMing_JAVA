package com.lanou3g;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //IO流
        //字符输出流的一个子类  叫文件输出流
        //可以进行文件的写操作

        FileWriter writer = null;

        try {
            writer = new FileWriter("Text.txt", true);
            //
            writer.write("锄禾日当午\n");
            writer.write("谁是锄禾,谁是当午\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
