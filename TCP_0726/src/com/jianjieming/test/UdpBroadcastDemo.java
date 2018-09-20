package com.jianjieming.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpBroadcastDemo {

    private static final String INET_BROADCAST_ADDRESS = "172.16.31.255";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket udp = new DatagramSocket(6789);
        new Thread(new UdpReceiver(udp)).start();

        while (true) {
            byte[] buf = sc.nextLine().getBytes();
            if (buf.length == 0) continue;
            InetAddress address = InetAddress.getByName(INET_BROADCAST_ADDRESS);
            DatagramPacket p = new DatagramPacket(buf, buf.length, address, 6789);
            udp.send(p);
        }

    }

    public static class UdpReceiver implements Runnable {
        private DatagramSocket udp;

        private UdpReceiver(DatagramSocket udp) {
            this.udp = udp;
        }

        @Override
        public void run() {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            try {
                while (true) {
                    udp.receive(dp);
//                    getOffset() 从哪开始
//                    dp.getLength() 要转换的长度
                    String msg = new String(dp.getData(), dp.getOffset(), dp.getLength());
                    String address = dp.getAddress().getHostAddress();
//                    判断字符串是不是空的,去掉前后空格是不是空的
                    if (msg.isEmpty() || msg.trim().isEmpty()) continue;
                    System.out.println(address + ": " + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
