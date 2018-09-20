package com.jianjieming.Test.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

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
public class GameUtil {
    public static Image getImage(String path){
        BufferedImage bi = null;
        ClassLoader loader = GameUtil.class.getClassLoader();//类加载器
        URL url = loader.getResource(path);
        try {
            bi = ImageIO.read(url);//静态方法
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}
