package code;

/**
 * 创建的一个金币类
 */
public class Money extends flyObject {
    public Money(int enemyx, int enemyy) {
        img = App.getImg("/img/money.jpg");
        w = img.getWidth();
        h = img.getHeight();
        x = enemyx;
        y = enemyy;
    }

    /**
     * 让金币飞
     */
    public void move() {
        y += 5;
    }
    /**
     * 抓取检测
     */
    /**
     * 碰撞检测
     */
    public boolean catchBy(Wingman wingman) {
        boolean catchM = x <= wingman.x + wingman.w && x >= wingman.x - w && y <= wingman.y + wingman.h && y >= wingman.y - h;
        return catchM;
    }
}
