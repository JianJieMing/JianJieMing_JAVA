package com.jianjieming.study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *
 * @author 铭
 */
public class ServerMain {
    public static void main(String[] args) {
        /*
            Socket 套接字
            在java中Socket类可以直接操作TCP协议
         */

        try {
//            创建服务端的Socket,设置需要监听的端口号.
            ServerSocket server = new ServerSocket(7890);
//            如果监听到有客户端连接端口了,就可以获取到连接过来的socket对象.
//            该方法是一个阻塞的方法.
//            坐等客户端连接
            while (true) {
                System.out.println("服务端已启动,开始监听7890端口!");
                Socket socket = server.accept();
//                InputStream is = socket.getInputStream();
//                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                System.out.println("等待客户端连接...");
                System.out.println("客户端已连接,IP地址和端口号为: " + socket.getRemoteSocketAddress());
                while (true) {
                    String s = br.readLine();
                    System.out.println("客户端说: " + s);
                    pw.println(s); // 自动换行
                    pw.flush(); // 冲一下
                    if (s == null || s.equals("bye")) {
                        break;
                    }
                }
            }
//            获取到输入流(客户端发送过来的数据)
//            获取输出流,给客户端发送数据.
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
