package com.jianjieming.demo;

import java.util.List;

public class Album {
    private String name;
    private List<Music> musicList;

    public Album() {
    }

    public Album(String name, List<Music> musicList) {
        this.name = name;
        this.musicList = musicList;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", musicList=" + musicList +
                '}';
    }

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
