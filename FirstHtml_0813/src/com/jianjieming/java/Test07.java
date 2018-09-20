package com.jianjieming.java;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 铭
 */
public class Test07 {
    public static void main(String[] args) {
        String url = "/Users/dllo/Desktop/未命名文件夹/imgs/109951163079930963.jpg";
        try {
            Socket socket = new Socket("localhost",6666);
            InputStream is = new FileInputStream(url);
            OutputStream os = socket.getOutputStream();
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
