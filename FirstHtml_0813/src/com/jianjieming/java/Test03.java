package com.jianjieming.java;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 铭
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SSS:
        while (true) {
            try {
                System.out.println("服务器以启动,等待客户端连接");
                ServerSocket socket = new ServerSocket(5555);
                Socket accept = socket.accept();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(accept.getInputStream()));
                PrintWriter pw = new PrintWriter(
                        new OutputStreamWriter(accept.getOutputStream()));
                System.out.println("客户端以连接,IP地址端口号为: " + accept.getRemoteSocketAddress());
                while (true) {
                    String s = br.readLine();
                    System.out.println("客户端说: " + s);
                    if (s.equals("bye")) {
                        System.out.println("服务器以关闭");
                        break SSS;
                    }
                    System.out.println("请输入: ");
                    String s1 = scanner.nextLine();
                    pw.println(s1);
                    pw.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
