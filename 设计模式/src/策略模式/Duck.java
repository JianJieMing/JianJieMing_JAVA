package 策略模式;


import 策略模式.call.DuckCall;
import 策略模式.flight.Flight;

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

    public void setFlyBehavior(Flight fb) {
        flight = fb;
    }

    public void setQuackBehavior(DuckCall qb) {
        duckCall = qb;
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
