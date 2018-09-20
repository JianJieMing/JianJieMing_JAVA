package 策略模式.duck;


import 策略模式.Duck;
import 策略模式.call.Call;
import 策略模式.flight.DuckFlight;

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

