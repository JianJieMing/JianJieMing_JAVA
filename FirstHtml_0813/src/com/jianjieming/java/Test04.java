package com.jianjieming.java;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 铭
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("客户度上线");
            Socket socket = new Socket("localhost", 5555);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(os));
            while (true) {
                System.out.println("请输入: ");
                String s1 = scanner.nextLine();
                writer.println(s1);
                writer.flush();
                String s = br.readLine();
                System.out.println("服务端说: " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
