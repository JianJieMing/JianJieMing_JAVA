package com.jianjieming.test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 铭
 */
public class 客户端 {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 4554);
        while (true){
            Scanner scanner = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());
            System.out.println("请输入: ");
            String s = scanner.nextLine();
            ps.println(s);
            ps.flush();

            String s1 = br.readLine();
            System.out.println("服务端: " + s1);

        }
    }
}
