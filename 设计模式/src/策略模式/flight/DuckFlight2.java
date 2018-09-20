package 策略模式.flight;

/**
 * @author 铭
 */
public class DuckFlight2 implements Flight {
    @Override
    public void flight() {
        System.out.println("高空飞行");
    }
}
