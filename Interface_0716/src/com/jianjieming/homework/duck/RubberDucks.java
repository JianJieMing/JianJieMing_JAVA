package com.jianjieming.homework.duck;

import com.jianjieming.homework.Duck;
import com.jianjieming.homework.call.Call2;
import com.jianjieming.homework.flight.NoFlight;

/**
 * 橡皮鸭类
 * @author 铭
 */
public class RubberDucks extends Duck {
    public RubberDucks() {
        setName("橡皮鸭");
        duckCall = new Call2();
        flight = new NoFlight();
    }
}
