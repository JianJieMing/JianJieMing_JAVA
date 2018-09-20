package com.lanou3g.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //IO流
        File file = new File("test.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            file.createNewFile();
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file);
            String a = "Hello XXX";
            fos.write(a.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
