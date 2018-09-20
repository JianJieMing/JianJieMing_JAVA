package com.jianjieming.study;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 铭
 */
public class HttpDemo {
    public static void main(String[] args) throws IOException {
        /*
            OkHttp 发送Http请求的框架

            发送Http请求步骤:
            1. 请求的地址.
            2. 指定请求方法(GET/POST).
                2.1 GET: 一般用来向服务器请求数据.
                2.2 POST: 一般用来发送数据.
            3. 设置请求头 简单的请求可以省略.
            4. 设置请求体 GET请求没有.
            5. 发送请求.
            6. 处理响应.
         */

        String url = "https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=bb5c8f8c83d4b31cf03c93bdbfed4042/2cf5e0fe9925bc31add1955756df8db1ca137075.jpg";

        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url(url) // 1.请求地址
                .get() // 2.可以不写,默认的就是get
//                .headers() // 3.
                .build();
//        5.发送请求,获取响应
        Response resp = client.newCall(request).execute();
//        6.处理响应
        InputStream in = resp.body().byteStream();
//        文件总大小
        long size = resp.body().contentLength();
        System.out.println("文件大小: " + size / 1024 + "KB");
        byte[] bytes = new byte[1024];
        double currentSize = 0;
        FileOutputStream fos = new FileOutputStream("girl.jpg");
        int length = -1;
        while ((length = in.read(bytes)) != -1) {
            fos.write(bytes, 0, length);
            currentSize += length;
            System.out.println("进度: " + (currentSize / size * 100) + "%");
        }
        fos.close();
        in.close();
    }
}
