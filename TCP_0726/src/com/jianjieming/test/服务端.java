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
        ServerSocket server = new ServerSocket(4554);
        Socket socket = server.accept();
        System.out.println("客户端已连接,ip端口号为: " + socket.getRemoteSocketAddress());
        while (true) {
            Scanner scanner = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            String s1 = br.readLine();
            System.out.println("客户端: " + s1);

            System.out.println("请输入: ");
            String s = scanner.nextLine();
            pw.println(s);
            pw.flush();
        }
    }
}
