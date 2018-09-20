package com.jianjieming.study.bean;

/**
 * @author 铭
 */
public class ScoreBean {
    private int SID;
    private int CID;
    private float score;
    @Override
    public String toString() {
        return "ScoreBean{" +
                "SID=" + SID +
                ", CID=" + CID +
                ", score=" + score +
                '}' + "\n";
    }


    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
