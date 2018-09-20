package com.jianjieming.test;

import java.util.List;

/**
 * @author 铭
 */
public class Abum {
    private String name;
    private List<Music> musicList;

    @Override
    public String toString() {
        return "Abum{" +
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
