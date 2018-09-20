package com.jianjieming.java;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * @author 铭
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("服务端已启动");
        try {
            DatagramSocket socket = new DatagramSocket(9999);
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
            while (true){
                socket.receive(dp);
                byte[] data = dp.getData();
                String str = new String(data,dp.getOffset(),dp.getLength());
                System.out.println("服务端接收到数据: " + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
