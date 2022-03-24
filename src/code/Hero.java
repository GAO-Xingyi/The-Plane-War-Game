package code;

import java.awt.image.BufferedImage;

public class Hero extends flyObject {
    int hp;//英雄机血量
//    //英雄机的图片
//    BufferedImage img ;
//    //英雄机的横坐标
//    int x;
//    //英雄机的纵坐标
//    int y;
//    //英雄机的宽度
//    int w;
//    //英雄机的高度
//    int h;

    /**
     * 构造方法：给对象定型（确定英雄机）
     * 构造方法：类似于做月饼的模具
     */

    public Hero() {
        //确定游戏开始时，英雄机显示的图片
        img = App.getImg("/img/hero.png");
        //确定英雄机的大小
        //使用图片的大小，作为飞机的大小
        w = img.getWidth();
        h = img.getHeight();
        //使用横纵坐标、确定英雄机在游戏开始时显示的位置
        x = 175;
        y = 650 - h;
        hp = 3;//英雄机的初始血量

    }


    //向上移动
    public void moveUp() {
        if (y >= 50)
            y -= 50;
    }

    //向下移动
    public void moveDown() {
        if (y <= 530)
            y += 50;
    }

    //向左移动
    public void moveLeft() {
        if (x >= 25)
            x -= 50;
    }

    //向右移动
    public void moveRight() {
        if (x <= 335)
            x += 50;
    }


}

