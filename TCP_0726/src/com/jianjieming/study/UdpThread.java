package com.jianjieming.study;

import java.io.IOException;
import java.net.*;

/**
 * @author 铭
 */
public class UdpThread extends Thread {

    @Override
    public synchronized void run() {
        int index = 0;
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        System.out.println("线程1客户端已启动");
        while (true) {
            index++;
            System.out.println("一号线程" + Thread.currentThread().getName());
            String ss = "大哥最帅";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            byte[] buf = ss.getBytes();
//        本机的IP地址  (广播地址: 172.16.31.255)
            InetAddress addr = null;

            try {
                addr = InetAddress.getByName("172.16.31.255");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

//        构建数据包
            DatagramPacket dp = new DatagramPacket(buf, buf.length, addr, 6789);
//        发送数据包

            try {
                socket.send(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (index == 20) {
                break;
            }
        }
    }
}
