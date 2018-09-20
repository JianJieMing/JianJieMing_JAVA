package 策略模式.duck;


import 策略模式.Duck;
import 策略模式.call.Call2;
import 策略模式.flight.NoFlight;

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
