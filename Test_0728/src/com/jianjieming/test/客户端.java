package com.jianjieming.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 铭
 */
public class 客户端 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端上线");
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1",7777);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        while (true){
            System.out.println("请输入: ");
            String s1 = scanner.nextLine();
            writer.println(s1);
            writer.flush();
            String s = br.readLine();
            System.out.println("服务端: " + s);
        }
    }
}
