package com.jianjieming.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author 铭
 */
public class Test06 {
    public static void main(String[] args) {
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534129109591&di=d41e74b66d89fce98870d803989496b5&imgtype=0&src=http%3A%2F%2Fp2.qhimgs4.com%2Ft01f1c1e6694bb8ccf3.jpg";
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            InputStream is = response.body().byteStream();
            FileOutputStream fos = new FileOutputStream(new File("TLD.jpg"));
            long l = response.body().contentLength();
            System.out.println("文件大小: " + (l / 1000) + "KB");
            int length = -1;
            double schedule = 0;
            byte[] bytes = new byte[1024];
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
