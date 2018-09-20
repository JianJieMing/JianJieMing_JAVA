package com.jianjieming.study;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 客户端
 *
 * @author 铭
 */
public class UdpClientDemo {
    public static void main(String[] args) throws Exception {
        Thread t = new UdpThread();
        Thread t2 = new UdpThread2();
        Scanner scanner = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket();
        System.out.println("客户端已启动");
        while (true) {
            System.out.println("请输入: ");
            String a = scanner.nextLine();
            byte[] buf = a.getBytes();
//        本机的IP地址  (广播地址: 172.16.31.255)
            InetAddress addr = InetAddress.getByName("172.16.31.255");
//        构建数据包
            DatagramPacket dp = new DatagramPacket(buf, buf.length, addr, 6789);
//        发送数据包
            socket.send(dp);
//            t.start();
//            t2.start();
        }
    }
}
