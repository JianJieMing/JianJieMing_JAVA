package com.jianjieming.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 铭
 */
public class 发送文件 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 5555);
        InputStream is = new FileInputStream("/Users/dllo/Desktop/未命名文件夹/imgs/109951163079930963.jpg");
        OutputStream os = socket.getOutputStream();

        int a = 0;
        byte[] bytes = new byte[1024 * 1024*10];
        while ((a = is.read(bytes)) != -1) {
            os.write(bytes,0,a);
        }
        os.close();
        is.close();
        socket.close();
    }
}
