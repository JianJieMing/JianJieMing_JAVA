package com.jianjieming.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author 铭
 */
public class Test02 {
    public static void main(String[] args) {

        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533909997570&di=f23fd4dcf927a2a60b0c253864b42182&imgtype=0&src=http%3A%2F%2Fi3.hoopchina.com.cn%2Fblogfile%2F201506%2F26%2FBbsImg143529380791855_1920*1080big.jpg";

        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response execute = client.newCall(request).execute();
            InputStream is = execute.body().byteStream();
            FileOutputStream fos = new FileOutputStream("poluo.jpg");
            long size = execute.body().contentLength();
            System.out.println("文件大小为: " + size / 1000 + "KB");
            byte[] bytes = new byte[1024];
            int length = -1;
            double currentSize = 0;
            while ((length = is.read(bytes)) != -1) {
                fos.write(bytes, 0, length);
                currentSize += length;
                System.out.println("进度: " + (currentSize / size * 100) + "%");
            }
            fos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
