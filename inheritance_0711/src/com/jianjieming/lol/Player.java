package com.jianjieming.lol;

/**
 * 玩家类
 * 控制英雄进行移动和攻击
 * 可以随时切换英雄
 *
 * @author 铭
 */
public class Player {
    private String name;

    public Hero control(int type) {
        switch (type) {
            case 1:
                return new AD("战士");
            case 2:
                return new AP("法师");
        }
        return null;
    }

    public void attack(){
        System.out.println(getName() + "正在攻击");
    }
    public void move(){
        System.out.println(getName() + "正在移动");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
