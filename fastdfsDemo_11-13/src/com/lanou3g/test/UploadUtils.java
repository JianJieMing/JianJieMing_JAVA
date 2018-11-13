package com.lanou3g.test;

import org.csource.fastdfs.*;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Arrays;

/**
 * @author 铭
 * 2018/11/13 15:50
 */
public class  UploadUtils {
    public static String getUpload(String srcPath, String type) {
        try {
            ClientGlobal.initByProperties("fastdfs.properties");
            System.out.println(ClientGlobal.configInfo());
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            FileInputStream fis = new FileInputStream(srcPath);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int length = -1;
            while ((length = fis.read(buff)) != -1) {
                out.write(buff, 0, length);
            }
            byte[] bytes = out.toByteArray();
            String[] strings = storageClient.upload_file(bytes, 0, bytes.length, type, null);
            String result = Arrays.toString(strings);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "网络异常";
    }

}
