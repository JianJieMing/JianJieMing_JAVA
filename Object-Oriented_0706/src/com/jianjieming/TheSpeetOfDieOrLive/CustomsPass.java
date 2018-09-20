package com.jianjieming.TheSpeetOfDieOrLive;

import java.util.Date;
import java.util.Scanner;

/**
 * 关卡
 *
 * @author 铭
 */
public class CustomsPass {
    public int cpId = 1;
    public int number;
    public int cpScores = 0;
    public int cpTime = 10;
    public int a = 0;
    public int i1 = 0;
    ThePlayer thePlayer2 = new ThePlayer();


    String cpId1 = "dshguis";
    String cpId2 = "gdhuiancia";
    String cpId3 = "erywoncyadjaih";
    String cpId4 = "unnilunlifkjaswdz";
    String cpId5 = "ytwisdkdbfcyiusodnbuyfa";


    public void initial() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (a == 0) {
//            SimpleDateFormat df = new SimpleDateFormat("mm:ss");//设置日期格式
//            System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            Date df8 = new Date();
            System.out.println("1-1,请输入: dshguis");
            String b = scanner.nextLine();
//            System.out.println("1-1,请输入: unnilunlifkjaswdz");
//            String b4 = scanner.nextLine();
//            System.out.println("1-1,请输入: ytwisdkdbfcyiusodnbuyfa");
//            String b5 = scanner.nextLine();
//            SimpleDateFormat df2 = new SimpleDateFormat("mm:ss");//设置日期格式
//            System.out.println(df.format(new Date()));
            Date df9 = new Date();
            long df10 = df9.getTime() - df8.getTime();
            long df11 = df10 / 1000;
//            System.out.println("相差" + df10 / 1000 + "秒");
//            if (df11 > 10 && b != cpId1) {
//                System.out.println("很遗憾挑战失败,用时" + df11 + "秒,总分" + cpScores + ",感谢您的参与!");
//                System.out.println("游戏结束");
//                break;
//            }
            if (b.equals(cpId1) && i1 <= 10) {
                cpScores++;
                System.out.println("恭喜!输入成功,用时" + df11 + "秒," + "得分1分," + "总分" + cpScores);
                cpId++;
                if (cpId == 2) {
                    Date d1 = new Date();
                    System.out.println("1-1,请输入: gdhuiancia");
                    String b2 = scanner.nextLine();
                    Date d2 = new Date();
                    long d3 = d2.getTime() - d1.getTime();
                    long d4 = d3 / 1000;
                    if (b2.equals(cpId2) && i1 <= 10) {
                        cpScores = cpScores + 10;
                        System.out.println("恭喜!输入成功,用时" + d4 + "秒," + "得分10分," + "总分" + cpScores);
                        cpId++;
                        if (cpId == 3) {
                            Date d8 = new Date();
                            System.out.println("1-1,请输入: erywoncyadjaih");
                            String b3 = scanner.nextLine();
                            Date d5 = new Date();
                            long d6 = d5.getTime() - d8.getTime();
                            long d7 = d6 / 1000;
                            if (b3.equals(cpId3) && i1 <= 10) {
                                cpScores = cpScores + 20;
                                System.out.println("恭喜!输入成功,用时" + d7 + "秒," + "得分20分," + "总分" + cpScores);
                                cpId++;
                                if (cpId == 4) {
                                    Date q1 = new Date();
                                    System.out.println("1-1,请输入: unnilunlifkjaswdz");
                                    String b4 = scanner.nextLine();
                                    Date q2 = new Date();
                                    long q3 = q2.getTime() - q1.getTime();
                                    long q4 = q3 / 1000;
                                    if (b4.equals(cpId4) && i1 <= 10) {
                                        cpScores = cpScores + 30;
                                        System.out.println("恭喜!输入成功,用时" + q4 + "秒," + "得分30分," + "总分" + cpScores);
                                        cpId++;
                                        if (cpId == 5) {
                                            Date w1 = new Date();
                                            System.out.println("1-1,请输入: ytwisdkdbfcyiusodnbuyfa");
                                            String b5 = scanner.nextLine();
                                            Date w2 = new Date();
                                            long w3 = w2.getTime() - w1.getTime();
                                            long w4 = w3 / 1000;
                                            if (b5.equals(cpId5) && i1 <= 10) {
                                                cpScores = cpScores + 150;
                                                System.out.println("恭喜您,通关啦,用时" + w4 + "秒," + "得分50分,额外加100分!" + "总分" + cpScores);
                                                cpId++;
                                                if (cpId == 6) {
                                                    System.out.println("欢迎下次光临");
                                                    break;
                                                }
                                            } else {
                                                System.out.println("很遗憾第五关挑战失败,用时" + w4 + "秒,总分" + cpScores + ",感谢您的参与!");
                                                System.out.println("游戏结束");
                                                break;
                                            }
                                        }

                                    } else {
                                        System.out.println("很遗憾第四关挑战失败,用时" + q4 + "秒,总分" + cpScores + ",感谢您的参与!");
                                        System.out.println("游戏结束");
                                        break;
                                    }
                                }

                            } else {
                                System.out.println("很遗憾第三关挑战失败,用时" + d7 + "秒,总分" + cpScores + ",感谢您的参与!");
                                System.out.println("游戏结束");
                                break;
                            }
                        }

                    } else {
                        System.out.println("很遗憾第二关挑战失败,用时" + d4 + "秒,总分" + cpScores + ",感谢您的参与!");
                        System.out.println("游戏结束");
                        break;
                    }
                }

            } else {
                System.out.println("很遗憾第一关挑战失败,用时" + df11 + "秒,总分" + cpScores + ",感谢您的参与!");
                System.out.println("游戏结束");
                break;
            }


        }
    }
}
