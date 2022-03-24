package code;
/**
 * 导弹类
 */

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bomb extends flyObject {
    public Bomb() {
        Random rd = new Random();
        img = App.getImg("/img/bomb1.png");
        w = img.getWidth();
        h = img.getHeight();
        //确定敌机的位置
        //nextInt(num),表示在[0,num)之间随机生成一个正数
        x = rd.nextInt(480 - w);
        y = -h;

    }

    public void run() {
        y += 10;
    }
}
