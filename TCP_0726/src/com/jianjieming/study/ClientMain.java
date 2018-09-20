package com.jianjieming.study;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 *
 * @author 铭
 */
public class ClientMain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 7890);
        System.out.println("客服端上线!!!");
//        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(socket.getOutputStream());
//        InputStream is = socket.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
            System.out.println("请输入: ");
            String s = scanner.nextLine();
            ps.println(s);
            ps.flush();
            String s2 = br.readLine();
            System.out.println("服务端说: " + s2);
            if (s == null || s.equals("bye")) {
                break;
            }
        }

    }
}
