package com.jianjieming.study.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * 龙哥
 *
 * @author 铭
 * DATE: 18/8/31 上午9:54
 */
public class DragonMan implements Subject {

    private List<Observer> observers = new ArrayList<>();

    // 龙哥下命令
    public void order() {
        String msg = "给我上!";
        System.out.println("大哥说: " + msg);
        notifyObserver(msg);
    }

    @Override
    public void notifyObserver(String message) {
        for (int i = 0; i < observers.size(); i++) {
            Observer o = observers.get(i);
            o.handleMessage(this, message);
            if (!observers.contains(o)) {
                i--;
            }
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
}
