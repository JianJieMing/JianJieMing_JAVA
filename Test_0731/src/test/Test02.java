package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author 铭
 */
public class Test02 {
    public static void main(String[] args) {
        String a = "/Users/dllo/Desktop/abc/a";
        String a1 = "/Users/dllo/Desktop/a.txt";
        String a2 = "/Users/dllo/Desktop/abc/a/a2.txt";
        File file = new File(a);
        File file1 = new File(a1);
        File file2 = new File(a2);
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            int length = -1;
            byte[] bytes = new byte[1024];
            while ((length = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, length);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtil.closeAll(fos,fis);
        }

    }
}
