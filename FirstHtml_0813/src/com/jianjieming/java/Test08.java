package com.jianjieming.java;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 铭
 */
public class Test08 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = new FileOutputStream("/Users/dllo/Desktop/MM.jpg");
            byte[] bytes = new byte[1024];
            int length = -1;
            while ((length = is.read(bytes)) != -1) {
                os.write(bytes, 0, length);
            }
            os.flush();
            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
