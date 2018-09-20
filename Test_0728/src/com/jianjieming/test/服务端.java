package com.jianjieming.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 铭
 */
public class 服务端 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端上线");
        Scanner scanner = new Scanner(System.in);
        ServerSocket server = new ServerSocket(7777);
        Socket accept = server.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()));
        System.out.println("客户端已连接,IP端口号为: "+accept.getRemoteSocketAddress());
        while (true) {
            String s = br.readLine();
            System.out.println("客户端: " + s);
            System.out.println("请输入: ");
            String s1 = scanner.nextLine();
            writer.println(s1);
            writer.flush();
        }
    }
}
