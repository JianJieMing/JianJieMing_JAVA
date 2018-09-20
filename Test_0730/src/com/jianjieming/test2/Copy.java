package com.jianjieming.test2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 铭
 */
public class Copy {
    public static void main(String[] args) throws IOException {

        String copy = "/Users/dllo/Desktop/abc/def";
        String copy1 = "/Users/dllo/Desktop/a.txt";
        String copy2 = "/Users/dllo/Desktop/abc/def/a2.txt";

        File file = new File(copy);
        File file1 = new File(copy1);
        File file2 = new File(copy2);

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            file.mkdirs();
            file1.createNewFile();
            fis = new FileInputStream(copy1);
            fos = new FileOutputStream(copy2);
            int a = 0;
            byte[] bytes = new byte[1024];
            while ((a = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, a);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
