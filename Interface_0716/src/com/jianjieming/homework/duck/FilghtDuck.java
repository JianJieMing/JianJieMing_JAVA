package com.jianjieming.homework.duck;

import com.jianjieming.homework.Duck;
import com.jianjieming.homework.call.Call;
import com.jianjieming.homework.flight.DuckFlight2;

/**
 * 飞鸭类
 * @author 铭
 */
public class FilghtDuck extends Duck {
    public FilghtDuck() {
        setName("飞鸭");
        duckCall = new Call();
        flight = new DuckFlight2();
    }
}
