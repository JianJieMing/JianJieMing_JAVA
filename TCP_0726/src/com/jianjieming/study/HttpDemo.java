package com.jianjieming.study;

import java.io.*;
import java.net.Socket;

/**
 * @author 铭
 */
public class HttpDemo {
    public static void main(String[] args) throws IOException {
        /*
            应用层协议
         */
        Socket socket = new Socket("www.baidu.com", 80);
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        osw.write("GET www.baidu.com HTTP/1.1\r\n");
        osw.write("Host: www.baidu.com\r\n");
        osw.write("\r\n");
        osw.write("\r\n");
        osw.flush();

        InputStream in = socket.getInputStream();
        InputStreamReader r = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(r);
        StringBuilder sb = new StringBuilder();

        String line = null;

        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        System.out.println(sb);
    }
}
