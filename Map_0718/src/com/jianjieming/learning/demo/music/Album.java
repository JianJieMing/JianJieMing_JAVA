package com.jianjieming.learning.demo.music;

import java.util.List;

public class Album {
    private String name;
    private List<Music> musicList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
}
