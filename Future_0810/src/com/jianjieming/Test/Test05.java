package com.jianjieming.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author 铭
 */
public class Test05 {
    public static void main(String[] args) {
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533959396194&di=d86db4813253e41f0068ec96ae95f47a&imgtype=0&src=http%3A%2F%2Fww1.sinaimg.cn%2Flarge%2Faaaf7dc8gw1eqc562l4rtj21hc0u00ws.jpg";
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            Response execute = client.newCall(request).execute();
            InputStream is = execute.body().byteStream();
            long size = execute.body().contentLength();
            System.out.println("文件大小: " + (size / 1000 + 1) + "KB");
            FileOutputStream fos = new FileOutputStream("JMY.jpg");
            byte[] bytes = new byte[1024];
            int length = -1;
            double schedule = 0;
            while ((length = is.read(bytes)) != -1) {
                fos.write(bytes, 0, length);
                schedule += length;
                System.out.println("进度: " + (schedule / size * 100) + "%");
            }
            fos.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
