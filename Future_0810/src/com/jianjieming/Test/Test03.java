package com.jianjieming.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author 铭
 */
public class Test03 {
    public static void main(String[] args) {

        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533911125459&di=92e9fdc607ec37298920e2fcae0d05c4&imgtype=0&src=http%3A%2F%2Fatt.bbs.duowan.com%2Fforum%2F201503%2F25%2F142957uwa3ssoz6cq36qci.jpg";

        OkHttpClient client = new OkHttpClient.Builder().build();

        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            InputStream is = response.body().byteStream();
            FileOutputStream fos = new FileOutputStream("poluo2.jpg");
            long l = response.body().contentLength();
            System.out.println("文件大小: " + (l / 1000 + 1) + "KB");
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
