package com.jianjieming.dev.bean;

public class Score {
    private int stuId;
    private String stuName;
    private int scoreYW;
    private int scoreSX;
    private int scoreYY;
    private int score;

    @Override
    public String toString() {
        return "Score{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", scoreYW=" + scoreYW +
                ", scoreSX=" + scoreSX +
                ", scoreYY=" + scoreYY +
                ", score=" + score +
                '}';
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getScoreYW() {
        return scoreYW;
    }

    public void setScoreYW(int scoreYW) {
        this.scoreYW = scoreYW;
    }

    public int getScoreSX() {
        return scoreSX;
    }

    public void setScoreSX(int scoreSX) {
        this.scoreSX = scoreSX;
    }

    public int getScoreYY() {
        return scoreYY;
    }

    public void setScoreYY(int scoreYY) {
        this.scoreYY = scoreYY;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
