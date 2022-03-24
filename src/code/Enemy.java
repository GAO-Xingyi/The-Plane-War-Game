package code;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 敌机类
 * 1、数量多  Java中存放多个数据  1、使用数组 2、集合
 * 这里数组的定义需要定义长度，但数量未知
 * 2、数量未知
 */

public class Enemy extends flyObject {
    //    BufferedImage img;//敌机图片
//    int x;//横坐标
//    int y;//纵坐标
//    int w;//宽度
//    int h;//高度
    int speed;//设置速度

    public Enemy() {
        //定义随机数的类
        Random rd = new Random();
        //生成一个随机数来选取图片
        int index = rd.nextInt(3) + 1;
        //确定敌机显示的图片
        img = App.getImg("/img/enemy" + index + ".png");
        //确定敌机的大小
        w = img.getWidth();
        h = img.getHeight();
        //确定敌机的位置
        //nextInt(num),表示在[0,num)之间随机生成一个正数
        x = rd.nextInt(480 - w);
        y = -h;
        //设置速度
        speed = 20 - index * 5;//飞机越大，速度越慢
    }

    /**
     * 敌机移动的方法
     */
    public void move() {
        y += speed;
    }

    /**
     * 碰撞检测
     */
    public boolean shootBy(Bullet b) {
        boolean hit = x <= b.x + b.w && x >= b.x - w && y <= b.y + b.h && y >= b.y - h;
        return hit;
    }

    /**
     * 装到英雄机
     */
    public boolean hitBy(Hero he) {
        boolean hitH = x <= he.x + he.w && x >= he.x - w && y <= he.y + he.h && y >= he.y - h;
        return hitH;
    }

    public boolean hitBy(Wingman he) {
        boolean hitH = x <= he.x + he.w && x >= he.x - w && y <= he.y + he.h && y >= he.y - h;
        return hitH;
    }
}
