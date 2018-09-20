package com.jianjieming.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 铭
 */
public class 广播服务端 {
    public static void main(String[] args) throws Exception {
        System.out.println("广播服务端已启动");
        DatagramSocket ds = new DatagramSocket(3333);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        while (true) {
            ds.receive(dp);
            byte[] data = dp.getData();
            String str = new String(data, dp.getOffset(), dp.getLength());
            System.out.println("收到数据: " + str);
        }
    }
}
