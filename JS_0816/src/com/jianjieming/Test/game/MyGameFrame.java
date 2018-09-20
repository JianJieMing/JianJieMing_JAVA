package com.jianjieming.Test.game;

import javax.swing.*;
import java.awt.*;

/***I am a pure sheep
 *
 *             FUCK AS YOU WISH
 *
 *            ::::``:::::::::'        .:::.
 *           ::::'   ':::::'       .::::::::.
 *         .::::'      ::::     .:::::::'::::.
 *        .:::'       :::::  .:::::::::' ':::::.
 *       .::'        :::::.:::::::::'      ':::::.
 *      .::'         ::::::::::::::'         ``::::.
 *  ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 *                    '.:::::'                    ':'````..
 */
public class MyGameFrame extends JFrame {
    Image bg = GameUtil.getImage("image/bg.jpg");
    Image plane = GameUtil.getImage("image/plane.png");
    private int planeX=250,planeY=250;
    private int bgX= 500,bgY = 500;
    int c = 0;
    //集合图片
//    java.util.List<Image> imageList = new ArrayList<>();
//    public MyGameFrame(){
//        for (int i = 0; i < 16; i++) {
//            int a = i+1;
//            Image image = GameUtil.getImage("images/"+a+".jpg");
//            imageList.add(image);
//        }
//
//    }





    //父类方法,自动启动 加载图片
    @Override
    public void paint(Graphics g) {
        g.drawImage(bg,0,0,null);
        g.drawImage(plane,planeX,planeY,null);
        planeX++;
        planeY++;
//        g.drawImage(imageList.get(c),150,150,null);



    }
    //父类方法 反复加载画面
    Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();
            while (true){
//                System.out.println(1);
                if (c<15) {
                    c++;
                }else {
                    c=0;
                }
                repaint();//重画
                try {
                    thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    //加载窗口
    public void launchFrame(){
        this.setTitle("动态窗口");
        this.setVisible(true);
        this.setSize(bgX,bgY);
        this.setLocation(300,300);

        thread.start();
    }


    public int getPlaneX() {
        return planeX;
    }

    public void setPlaneX(int planeX) {
        this.planeX = planeX;
    }

    public int getPlaneY() {
        return planeY;
    }

    public void setPlaneY(int planeY) {
        this.planeY = planeY;
    }
}
