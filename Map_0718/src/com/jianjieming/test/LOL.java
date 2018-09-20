package com.jianjieming.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 */
public class LOL {
    public static void main(String[] args) {
        List<英雄联盟> lolList = new ArrayList<>();
        英雄联盟 LOL = new 英雄联盟();
        LOL.setName("我方阵容: ");
        lolList.add(LOL);

        List<英雄> roleList = new ArrayList<>();
        LOL.set英雄大全(roleList);

        英雄 role1 = new 英雄();
        role1.setName("卡特");
        role1.setBackgroundStory("中单刺客法师");
        roleList.add(role1);

        英雄 role2 = new 英雄();
        role2.setName("寒冰");
        role2.setBackgroundStory("远程物理ADC");
        roleList.add(role2);

        英雄 role3 = new 英雄();
        role3.setName("瑞文");
        role3.setBackgroundStory("上单爆发战士");
        roleList.add(role3);

        英雄 role4 = new 英雄();
        role4.setName("盲僧");
        role4.setBackgroundStory("野区瞎比打野");
        roleList.add(role4);

        英雄 role5 = new 英雄();
        role5.setName("琴女");
        role5.setBackgroundStory("萌妹大奶辅助");
        roleList.add(role5);

        英雄联盟 LOL2 = new 英雄联盟();
        LOL2.setName("敌方阵容: ");
        lolList.add(LOL2);

        List<英雄> roleList2 = new ArrayList<>();
        LOL2.set英雄大全(roleList2);

        英雄 role11 = new 英雄();
        role11.setName("亚索");
        role11.setBackgroundStory("中单快乐风男");
        roleList2.add(role11);

        英雄 role22 = new 英雄();
        role22.setName("女警");
        role22.setBackgroundStory("远程物理ADC");
        roleList2.add(role22);

        英雄 role33 = new 英雄();
        role33.setName("提莫");
        role33.setBackgroundStory("上单提莫必须死");
        roleList2.add(role33);

        英雄 role44 = new 英雄();
        role44.setName("赵信");
        role44.setBackgroundStory("野区菊花依在");
        roleList2.add(role44);

        英雄 role55 = new 英雄();
        role55.setName("奶妈");
        role55.setBackgroundStory("抠脚大汉毒奶");
        roleList2.add(role55);


        for (英雄联盟 英雄联盟 : lolList) {
            String name = 英雄联盟.getName();
            System.out.println("欢迎来到英雄联盟!!! " + "\n" + name);
            List<英雄> 英雄大全 = 英雄联盟.get英雄大全();
            for (英雄 英雄 : 英雄大全) {
                String name1 = 英雄.getName();
                String backgroundStory = 英雄.getBackgroundStory();
                System.out.println("\t" + name1 + "  " + backgroundStory);
            }
        }


    }
}
