package code;

/**
 * 创造僚机类
 */
public class Wingman extends flyObject {
    int hp;

    public Wingman() {
        img = App.getImg("/img/wingman.png");
        w = img.getWidth();
        h = img.getHeight();
        x = 300;
        y = 600 - h;
        hp = 5;
    }

    public void moveToMouse(int mx, int my) {
        x = mx - w / 2;//将鼠标居于僚机正中
        y = my - h / 2;//将鼠标居于僚机正中
    }

    /**
     * 检测是否达到加血要求
     */
    public boolean meet(Hero hero) {
        boolean meetH = x <= hero.x + hero.w && x >= hero.x - w && y <= hero.y + hero.h && y >= hero.y - h;
        return meetH;
    }
}
