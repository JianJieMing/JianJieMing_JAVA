package com.jianjieming.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 铭
 */
public class Test04 {
    public static void main(String[] args) {
        List<Map<String, Object>> albumList = new ArrayList<>();
        Map<String, Object> album = new HashMap<>();
        albumList.add(album);
        album.put("album","专辑");
        List<Map<String,Object>> musicList = new ArrayList<>();
        album.put("musics",musicList);
        Map<String,Object> music = new HashMap<>();
        musicList.add(music);
        music.put("music","歌曲1");
        Map<String,Object> music2 = new HashMap<>();
        musicList.add(music2);
        music2.put("music","歌曲2");
        Map<String,Object> music3 = new HashMap<>();
        musicList.add(music3);
        music3.put("music","歌曲3");

        Map<String,Object> album2 = new HashMap<>();
        album2.put("album","专辑2");
        albumList.add(album2);
        List<Map<String,Object>> musicList2 = new ArrayList<>();
        album2.put("musics",musicList2);
        Map<String,Object> music44 = new HashMap<>();
        musicList2.add(music44);
        music44.put("music","歌曲44");
        Map<String,Object> music55 = new HashMap<>();
        musicList2.add(music55);
        music55.put("music","歌曲55");
        Map<String,Object> music66 = new HashMap<>();
        musicList2.add(music66);
        music66.put("music","歌曲66");

        for (Map<String, Object> map : albumList) {
            Object album1 = map.get("album");
            System.out.println("专辑: " + album1);
            Object musics = map.get("musics");
            List<Map<String,String>>  musicsList = (List<Map<String, String>>) map.get("musics");
            for (Map<String, String> stringStringMap : musicsList) {
                String music1 = stringStringMap.get("music");
                System.out.println("\t歌曲名称: " + music1);

            }
        }


    }
}
