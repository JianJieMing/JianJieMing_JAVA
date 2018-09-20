package com.lanou3g.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        List<Music> musicList = new ArrayList<>();
        List<Album> albumList = new ArrayList<>();
        String line = "";
        while ((line = br.readLine()) != null) {

            if (!line.startsWith(" ")) {
                Album album = new Album();
                album.setName(line);
                albumList.add(album);
                album.setMusicList(musicList);
//                System.out.println(album.getName());
//                System.out.println(musicList);
            } else {
                Music music = new Music();
                String trim = line.trim();
                music.setMusicName(trim);
                musicList.add(music);
//                System.out.println(music.getMusicName());
            }
        }
       System.out.println(albumList);
    }
}
