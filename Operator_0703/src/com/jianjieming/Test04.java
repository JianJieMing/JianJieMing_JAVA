package com.jianjieming;

public class Test04 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入你的java初级分数");
//        int b = scanner.nextInt();
//        System.out.println("请输入你的java中级分数");
//        int a = scanner.nextInt();
//        System.out.println("请输入你的java高级分数");
//        int c = scanner.nextInt();
//        if (c >= 90 && c <= 100) {
//            System.out.println("一等奖学金200元");
//        } else if (c >= 80){
//            System.out.println("二等奖学金 奖励个妹子");
//        } else if (c >= 60){
//            System.out.println("三等奖学金 奖励个娃娃");
//        } else {
//            System.out.println("没奖励");
//        }

//        练习:
//              百米跑步的成绩,如果是男的那么成绩需要小于11秒才进入决赛,
//              如果是女的,那么成绩需要小于12秒进入决赛
        char gender = 'F';

        float time = 11.8F;

        if (gender == 'M') {
            if (time < 11) {
                System.out.println("进入男子组决赛");
            }
        } else if (gender != 'M') {
            if (time < 12) {
                System.out.println("进入女子组决赛");
            }
        }

//        判断两个字符串是否相等用equals,不要用==
        String sex = "男";
        if (sex.equals("男")) {
            System.out.println("我是男人");
        }

    }
}
