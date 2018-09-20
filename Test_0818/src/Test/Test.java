package Test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * public static void writeStringToFile(File file, String data, String charSetName);
 * public static String readFileToString(File file, String charSetName);指定编码表读取内容
 * public static void copyFile(File srcFile, File destFile);拷贝文件
 * public static void copyDirectory(File srcDir, File destFile); 拷贝文件夹里面的内容
 * public static void copyDirectoryToDirectory(File srcDir, File destFile);拷贝整个文件夹到新的文件夹
 * public static void forceDelete(File file); 删除文件
 * public static void deleteDirectory(File dirFlie); 删除文件夹
 */
public class Test {
    public static void main(String[] args) throws IOException {

        File file = new File("hello.properties");
        /**
         * 判断hello.properties文件是否存在，如果不存在，创建该文件
         */
        if (!file.exists()) {
            file.createNewFile();
        }

        /**
         * 写入字符串到指定的文件中
         */
        FileUtils.writeStringToFile(file, "helloworld", "UTF-8");

        /**
         * 指定编码表读取内容
         */
        String str = FileUtils.readFileToString(file, "UTF-8");
        System.out.println(str);

        /**
         * 复制文件,a.txt文件不存在，会自动创建该文件，将file文件里面的内容即helloworld复制到a.txt
         */
        FileUtils.copyFile(file, new File("a.txt"));

        /**
         * 复制文件夹里面的内容到新的文件夹，如果新文件夹不存在自动创建
         */
        File srcDir = new File("/Users/dllo/Desktop/test2");
        File destDir = new File("/Users/dllo/Desktop/test");
        FileUtils.copyDirectory(destDir, srcDir);

        /**
         * 拷贝整个文件夹到新的文件夹,如果新文件夹不存在自动创建
         */
        FileUtils.copyDirectoryToDirectory(destDir,srcDir);

        /**
         * 删除文件
         */
        FileUtils.forceDelete(file);

        /**
         * 删除文件夹
         */
        FileUtils.deleteDirectory(destDir);
    }
}