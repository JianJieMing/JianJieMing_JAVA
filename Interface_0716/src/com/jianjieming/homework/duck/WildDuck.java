package com.jianjieming.homework.duck;

import com.jianjieming.homework.Duck;
import com.jianjieming.homework.call.Call;
import com.jianjieming.homework.flight.DuckFlight;

/**
 * 野鸭类
 * @author 铭
 */
public class WildDuck extends Duck {
    public WildDuck() {
        setName("野鸭");
        duckCall = new Call();
        flight = new DuckFlight();
    }
}

