package com.jianjieming.test;

import com.jianjieming.test.entity.Album;
import com.jianjieming.test.entity.Music;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class AlbumMain {
    public static void main(String[] args) {
        List<Album> albumList = new ArrayList<>();
        Album album = new Album();
        album.setName("专辑1");
        albumList.add(album);

        List<Music> musicList = new ArrayList<>();
        album.setMusicList(musicList);
        Music music1 = new Music("歌曲1", 100);
        musicList.add(music1);
        Music music2 = new Music("歌曲2", 200);
        musicList.add(music2);
        Music music3 = new Music("歌曲3", 300);
        musicList.add(music3);

        Album album2 = new Album();
        album2.setName("专辑2");
        albumList.add(album2);

        List<Music> musicList2 = new ArrayList<>();
        album2.setMusicList(musicList);
        Music music11 = new Music("歌曲11", 400);
        musicList.add(music11);
        Music music22 = new Music("歌曲22", 500);
        musicList.add(music22);
        Music music33 = new Music("歌曲33", 600);
        musicList.add(music33);

        for (Album album1 : albumList) {
            String name = album1.getName();
            System.out.println("\n专辑名称: " + name);
            List<Music> musicList1 = album1.getMusicList();
            for (Music music : musicList1) {
                String name1 = music.getName();
                int time = music.getTime();
                System.out.printf("\t" + "歌曲名称: %s,歌曲时长: %s", name1, time);
            }
        }


    }
}
