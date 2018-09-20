package com.jianjieming.study;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jianjieming.study.entity.Album;
import com.jianjieming.study.entity.Music;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author 铭
 */
public class JsonDemo {
    public static void main(String[] args) throws Exception {
        /*
            JSON格式
            JSON格式的数据由两种数据类型组成:
            第一种: {} 括起来的部分叫做对象.
            第二种: [] 括起来的部分叫做数组或集合.

            对象中的数据都是以键值对(key--value)的形式保存的.
            key 一定是字符串, value 可以是数字/字符串/布尔/对象/null/数组.

            解析JSON数据常用三种框架: 用哪个都行.
                1. jackson
                2. gson
                3. fastJson     阿里巴巴出品
         */

//        解析步骤:
//        1. 创建gson对象.
        Gson gson = new Gson();
//        2. 判断json数据的最外层的数据类型,确定解析的结果数据类型.最外层是中括号[]使用.
        Type type = new TypeToken<List<Album>>() {
        }.getType();// 相当于创建了一个匿名子类对象
//        3. 开始解析
        Reader r = new FileReader("album-list.json");
        List<Album> albumList = gson.fromJson(r, type);

        for (Album album : albumList) {
            System.out.println(album.getAlbumName());
            List<Music> musicList = album.getMusicList();
            for (Music music : musicList) {
                System.out.println(music.getMusicName());
                System.out.println(music.getDuration());
            }
        }

//        解析最外层是大括号{}的情况

//        1. 创建Gson对象
//        2. 分析结果类型
//        3. 解析

        System.out.println("\n++++++++++++++++++++++\n");

        Reader reader = new FileReader("album.json");
        Album album = gson.fromJson(reader, Album.class);
        System.out.println(album.getAlbumName());
        List<Music> musicList = album.getMusicList();
        for (Music music : musicList) {
            System.out.println(music);
        }

//        将对象序列化成字符串
        String json = gson.toJson(album);
        System.out.println("***************");
        System.out.println(json);

        File file = new File("test.json");

        FileOutputStream fos = null;

        fos = new FileOutputStream(file);
        fos.write(json.getBytes());

    }
}
