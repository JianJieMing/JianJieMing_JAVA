package com.lanou3g;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectDemo {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("object.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object o = ois.readObject();
        Goods g = (Goods) o;

        System.out.println(g.getName());
        System.out.println(g.getPrice());

        ois.close();
        fis.close();

        //
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write("asdfadsfdsafdsaf".getBytes());
        byte[] bytes = baos.toByteArray();

    }
}
