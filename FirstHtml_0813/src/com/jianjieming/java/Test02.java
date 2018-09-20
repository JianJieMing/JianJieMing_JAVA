package com.jianjieming.java;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author 铭
 */
public class Test02 {
    public static void main(String[] args) {
        String url = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3774766855,1598120654&fm=27&gp=0.jpg";
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            InputStream is = response.body().byteStream();
            FileOutputStream fos = new FileOutputStream(new File("a.jpg"));
            long l = response.body().contentLength();
            System.out.println("文件大小: " + (l / 1000) + "KB");
            byte[] bytes = new byte[1024];
            int length = -1;
            double schedule = 0;
            while ((length = is.read(bytes)) != -1) {
                fos.write(bytes, 0, length);
                schedule += length;
                System.out.println("进度: " + (schedule / l * 100) + "%");
            }
            fos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
