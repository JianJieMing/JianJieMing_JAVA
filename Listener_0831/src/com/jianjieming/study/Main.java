package com.jianjieming.study;

import com.jianjieming.study.button.Button;
import com.jianjieming.study.observe.*;

/**
 * @author 铭
 * DATE: 18/8/31 上午9:45
 */
public class Main {
    public static void main(String[] args) {

        DragonMan dragonMan = new DragonMan();
        BMW bmw = new BMW();
        Servant servant = new Servant();
        Knife knife = new Knife();
        People people = new People();

        dragonMan.addObserver(bmw);
        dragonMan.addObserver(servant);
        dragonMan.addObserver(knife);
        dragonMan.addObserver(people);

        dragonMan.order();
        System.out.println("*******");
        dragonMan.order();
        dragonMan.order();

        System.out.println("+++++++++++++");

        Button button = new Button();
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(Button btn) {
                System.out.println("自定义的点击事件");
            }
        });
        button.performClick();
    }
}
