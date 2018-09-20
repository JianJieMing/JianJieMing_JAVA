package com.jianjieming.java;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author 铭
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            DatagramSocket socket = new DatagramSocket();
            System.out.println("客户端已启动");
            while (true) {
                System.out.println("请输入: ");
                String s = scanner.nextLine();
                byte[] bytes = s.getBytes();
                InetAddress addr = InetAddress.getByName("172.16.31.255");
                DatagramPacket dp = new DatagramPacket(bytes,bytes.length,addr,9999);
                socket.send(dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
