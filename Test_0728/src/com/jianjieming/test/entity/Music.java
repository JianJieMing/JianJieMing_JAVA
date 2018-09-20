package com.jianjieming.test.entity;

/**
 * @author 铭
 */
public class Music {
    private String name;
    private int time;

    public Music(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
