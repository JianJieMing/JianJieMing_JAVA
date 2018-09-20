package com.jianjieming.test.entity;

import java.util.List;

/**
 * @author 铭
 */
public class Album {
    private String name;
    private List<Music> musicList;

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
