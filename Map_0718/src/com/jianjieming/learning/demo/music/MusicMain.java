package com.jianjieming.learning.demo.music;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class MusicMain {
    public static void main(String[] args) {

//        专辑集合
        List<Album> albus = new ArrayList<>();
//        创建一个专辑
        Album jay = new Album();
        jay.setName("Jay");
        albus.add(jay);
//        音乐集合
        List<Music> musicList = new ArrayList<>();
//        把音乐集合放入专辑中
        jay.setMusicList(musicList);
//        创建一个音乐
        Music music = new Music();
        music.setMusicName("斗牛");
        music.setMusicDuration("200");
//        把一首音乐放到音乐集合中
        musicList.add(music);

//        专辑二
        Album bdkj = new Album();
        bdkj.setName("八度空间");
        albus.add(bdkj);

        List<Music> musicList2 = new ArrayList<>();
        bdkj.setMusicList(musicList2);

        Music music2 = new Music();
        music2.setMusicName("菊花残");
        music2.setMusicDuration("333");
        musicList2.add(music2);

        Music music3 = new Music();
        music3.setMusicName("满地伤");
        music3.setMusicDuration("444");
        musicList2.add(music3);


        for (Album albu : albus) {
            String name = albu.getName();
            System.out.println("专辑名称: " + name);
            List<Music> musicList1 = albu.getMusicList();
            for (Music music1 : musicList1) {
                String musicName = music1.getMusicName();
                String musicDuration = music1.getMusicDuration();
                System.out.println("\t" + "音乐名称:" + musicName + "   音乐时长" + musicDuration);
            }
        }

        String name = albus.get(1).getMusicList().get(1).getMusicName();

        System.out.println("\n\t第二张专辑的第二首歌的名字: " + name);


    }
}
