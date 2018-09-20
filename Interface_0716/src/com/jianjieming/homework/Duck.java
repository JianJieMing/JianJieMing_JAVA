package com.jianjieming.homework;

import com.jianjieming.homework.call.DuckCall;
import com.jianjieming.homework.flight.Flight;

/**
 * @author 铭
 */
public class Duck {
    private String name;
    protected DuckCall duckCall;
    protected Flight flight;

    public Duck() {
    }

    public void PerformDuckCall() {
        duckCall.DuckCall();
    }

    public void PerformFlight() {
        flight.flight();
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Duck setDuckCall(DuckCall duckCall) {
        this.duckCall = duckCall;
        return this;
    }

    public Duck setFlight(Flight flight) {
        this.flight = flight;
        return this;
    }
}
