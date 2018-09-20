package 策略模式;

import 策略模式.duck.FilghtDuck;
import 策略模式.duck.RubberDucks;
import 策略模式.duck.WildDuck;
import 策略模式.flight.FlyRocketPowered;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        Duck duck = new WildDuck();
        System.out.println(duck.getName());
        duck.PerformDuckCall();
        duck.PerformFlight();
        System.out.println("**********************");
        Duck duck1 = new RubberDucks();
        System.out.println(duck1.getName());
        duck1.PerformDuckCall();
        duck1.PerformFlight();
        duck1.setFlyBehavior(new FlyRocketPowered());
        duck1.PerformFlight();
        System.out.println("**********************");
        Duck duck2 = new FilghtDuck();
        System.out.println(duck2.getName());
        duck2.PerformDuckCall();
        duck2.PerformFlight();
    }
}
