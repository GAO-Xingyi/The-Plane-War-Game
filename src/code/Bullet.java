package code;

/**
 * 子弹类：属于飞行物
 */
public class Bullet extends flyObject {
    /**
     * 构造方法：初始化子弹
     * herox英雄机的横坐标
     * heroy英雄机的纵坐标
     */
    public Bullet(int herox, int heroy) {
        //确定子弹的图片
        img = App.getImg("/img/bomb.png");
        //确定子弹的大小
        w = img.getWidth();
        h = img.getHeight();
        //确定子弹的位置（初始位置在英雄机上）
        x = herox + 5;
        y = heroy - 5;
    }

    /**
     * 让子弹飞
     */
    public void move() {
        y -= 8;
    }
}
