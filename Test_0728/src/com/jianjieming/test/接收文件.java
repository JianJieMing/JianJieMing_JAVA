package com.jianjieming.test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 铭
 */
public class 接收文件 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5555);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = new FileOutputStream(" /Users/dllo/Desktop/接收文件.jpg");
        int a = 0;
        byte[] bytes = new byte[1024*1024*10];
        while ((a = is.read(bytes)) != -1) {
            os.write(bytes,0,a);
        }
        os.flush();
        socket.close();
        is.close();
        os.close();
    }
}
