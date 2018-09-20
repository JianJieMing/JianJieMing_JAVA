package com.jianjieming.study;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * 服务端
 *
 * @author 铭
 */
public class UdpServerDemo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("服务端已启动");
        DatagramSocket ds = new DatagramSocket(6789);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
//        把接收到的数据存储到dp对象中
//        阻塞的方法.
        while (true) {
            ds.receive(dp);
//        读取数据
            byte[] data = dp.getData();
            String str = new String(data,dp.getOffset(),dp.getLength());
            System.out.println("服务端接收到数据: " + str);
        }
    }
}
