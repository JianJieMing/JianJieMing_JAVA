package 策略模式.duck;


import 策略模式.Duck;
import 策略模式.call.Call;
import 策略模式.flight.DuckFlight2;

/**
 * 飞鸭类
 *
 * @author 铭
 */
public class FilghtDuck extends Duck {
    public FilghtDuck() {
        setName("飞鸭");
        duckCall = new Call();
        flight = new DuckFlight2();
    }
}
