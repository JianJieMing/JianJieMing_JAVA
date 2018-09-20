package com.jianjieming.study.entity;

/**
 * @author 铭
 */
public class Music {
    private String musicName;
    private int duration;

    @Override
    public String toString() {
        return "Music{" +
                "musicName='" + musicName + '\'' +
                ", duration=" + duration +
                '}';
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
