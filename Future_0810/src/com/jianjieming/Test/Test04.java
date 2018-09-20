package com.jianjieming.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author 铭
 */
public class Test04 {
    public static void main(String[] args) {
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533958441561&di=316f74a14fe3301d288485b9501776a2&imgtype=0&src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2F7670124a64017d5757373f871bd00f994894cb1c.jpg";
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            InputStream is = response.body().byteStream();
            FileOutputStream fos = new FileOutputStream("lol.jpg");
            long l = response.body().contentLength();
            System.out.println("文件大小: " + (l / 1000 + 1) + "KB");
            int length = -1;
            double ss = 0;
            byte[] bytes = new byte[1024];
            while ((length = is.read(bytes)) != -1) {
                fos.write(bytes, 0, length);
                ss += length;
                System.out.println("进度: " + (ss / l * 100) + "%");
            }
            fos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
