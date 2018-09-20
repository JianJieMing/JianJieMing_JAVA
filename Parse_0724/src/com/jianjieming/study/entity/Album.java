package com.jianjieming.study.entity;

import java.util.List;

/**
 * @author 铭
 */
public class Album {
    private String albumName;
    private List<Music> musicList;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
}
