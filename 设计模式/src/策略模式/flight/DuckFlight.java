package 策略模式.flight;

/**
 * @author 铭
 */
public class DuckFlight implements Flight {
    @Override
    public void flight() {
        System.out.println("水面飞行");
    }
}
