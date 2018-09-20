package com.jianjieming.study.homework;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接收文件
 *
 * @author 铭
 */
public class FtpReceive {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(7890);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = new FileOutputStream("/Users/dllo/Desktop/接收文1件.jpg");

        byte[] bytes = new byte[1024 * 1024 * 10];
        int line = 0;
        while ((line = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, line);
        }
        outputStream.flush();
        socket.close();
        inputStream.close();
        outputStream.close();
    }
}
