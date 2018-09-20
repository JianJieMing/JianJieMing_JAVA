package com.jianjieming.src.com.lanou3g.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E2 {
    public static void main(String[] args) throws IOException {

        String inputPath = "/Users/Risky/Desktop/a.txt";
        String outputPath = "/Users/Risky/Desktop/abc/def/a.txt";
        File outFile = new File(outputPath);
        File parentFile = outFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!outFile.exists()) {
            outFile.createNewFile();
        }
        FileInputStream in = new FileInputStream(inputPath);
        FileOutputStream out = new FileOutputStream(outFile);
        byte[] buf = new byte[256];
        int length = -1;
        while ((length = in.read(buf)) != -1){
            out.write(buf, 0, length);
        }
        out.close();
        in.close();


    }
}
