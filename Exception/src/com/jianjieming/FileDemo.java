package com.jianjieming;

import java.io.File;
import java.io.IOException;

/**
 * @author 铭
 */
public class FileDemo {
    public static void main(String[] args) {
//        文件夹
        /*
            路径`
            绝对路径: 从硬盘的根目录开始一直到某个文件的路径.
            /Users/dllo/Desktop/未命名文件夹\ 2
            相对路径: 相对于某个文件夹定位文件的路径

            终端命令:   cd ~/Desktop
                      touch 创建文本文件
         */

        String path = "/Users/dllo/Desktop/test.rtf";
        File file = new File(path);
//        获取文件名字
        System.out.println(file.getName());
//        获取上层目录的绝对路径
        System.out.println(file.getParent());
//        获得文件绝对路径
        System.out.println(file.getPath());
//        判断文件是否纯在.
        System.out.println(file.exists());
//        判断是否是文件
        System.out.println(file.isFile());
//        判断是否是文件夹
        System.out.println(file.isDirectory());
//        列出该目录下的所有文件
        File[] files = file.listFiles();
        try {
//            新建文件
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        获取文件大小,单位是字节.Byte
        System.out.println(file.length());
//        创建最后一级的文件夹
        file.mkdir();
//        创建多级文件夹
        file.mkdirs();

//        列出桌面上所有文件夹
        File desktop = new File("/Users/dllo/Desktop/");
//        获取该文件夹下的所有文件
        File[] listFiles = desktop.listFiles();
        for (File listFile : listFiles) {
//            获取文件名称
            String name = listFile.getName();
//            判断是不是文件
            boolean file1 = listFile.isFile();
//            获取文件大小
            long length = listFile.length();
            System.out.printf("文件名: %s  是否是文件: %s  文件大小: %s KB \n", name, file1, length);
        }



        System.out.println("***************");
        list(new File("/Users/dllo/Desktop/我的资料库/"));


    }

    public static void list(File file){
        if (file.getName().endsWith(".md")){
//            打印file信息
            System.out.printf("md文件为: %s 文件大小: %s \n",file.getName(),file.length());
        } else if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                list(file1);

            }
        }
    }


}

/*
    列出桌面子文件夹中的所有图片名称和大小.
 */
