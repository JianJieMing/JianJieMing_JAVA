package com.jianjieming.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author 铭
 */
public class 广播客户端 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端已启动");
        Scanner scanner = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket();
        while (true) {
            System.out.println("请输入: ");
            String s = scanner.nextLine();
            byte[] bytes = s.getBytes();
            InetAddress addr = InetAddress.getByName("172.16.31.255");
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, addr, 3333);
            socket.send(dp);
        }
    }
}
