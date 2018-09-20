package 策略模式.flight;

/**
 * @author 铭
 */
public class FlyRocketPowered implements Flight {
    @Override
    public void flight() {
        System.out.println("火箭动力飞行");
    }
}
