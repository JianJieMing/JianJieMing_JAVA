package com.lanou3g.homework;

public class Music {
        private String musicName;



    @Override
    public String toString() {
        return "Music{" +
                "musicName='" + musicName + '\''+'\n';
    }

    public String getMusicName() {
            return musicName;
        }

        public void setMusicName(String musicName) {
            this.musicName = musicName;
        }

    }


