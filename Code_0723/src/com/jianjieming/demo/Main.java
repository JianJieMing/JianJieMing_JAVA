package com.jianjieming.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader r = new FileReader("music.txt");
        BufferedReader br = new BufferedReader(r);

        List<Album> albumList = new ArrayList<>();

        /*
        replaceAll
        split
        matches
         */
        String line = null;
        while ((line = br.readLine()) != null){
            if (line.startsWith(" ") && !line.startsWith("    ")){
                String albumName = line.trim();
                Album album = new Album();
                album.setName(albumName);
                List<Music> musicList = new ArrayList<>();
                album.setMusicList(musicList);
                albumList.add(album);
            } else if (line.startsWith("    ")){
                String musicStr = line.trim();
                String[] items = musicStr.split(" ");
                Music music = new Music();
                music.setId(items[0]);
                music.setName(items[1]);
                music.setDuration(Integer.parseInt(items[2]));

                Album album = albumList.get(albumList.size() - 1);
                List<Music> musicList = album.getMusicList();
                musicList.add(music);
            }
        }

        br.close();
        r.close();

        for (Album album : albumList) {
            System.out.println(album.getName());
            List<Music> musicList = album.getMusicList();
            for (Music music : musicList) {
                System.out.println("\t" + music);
            }
        }

    }
}
