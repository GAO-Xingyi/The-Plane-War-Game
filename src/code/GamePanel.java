package code;

import sun.awt.windows.ThemeReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Java中的游戏面板： JPanel
 * 自定义游戏面板
 * 1、写一个类，继承JPanel
 * 2、写一个构造方法，初始化（确定）面板的属性
 * <p>
 * 画图片的步骤：
 * 1、在类中定义图片，并取名
 * 2、在构造方法中，调用工具初始化图片
 * 3、在画图方法，paint中，画图片
 */
public class GamePanel extends JPanel {
    //1、定义背景图
    BufferedImage bg;//背景图

    //创建英雄机
    Hero hero = new Hero();

    //创建僚机
    Wingman wingman = new Wingman();

    //创建导弹
    Bomb bomb = new Bomb();

//    //创建敌机
//    Enemy enemy = new Enemy();

    //创建敌机的集合
    List<Enemy> ens = new ArrayList<Enemy>();//<Enemy>为范型规定为Enemy

    //创建子弹集
    List<Bullet> bul = new ArrayList<Bullet>();

    //创建金币集
    List<Money> mon = new ArrayList<Money>();


    //定义金币数
    int score = 0;
    //定义击杀量
    int num = 0;
    //设置游戏开关
    boolean gameover;//游戏开始时gameover为false
    boolean wingmanDie;
    boolean bombHoo = false;
    boolean bombRun = false;

    /**
     * 开始游戏的方法
     */
    public void startGame() {
        //创建并启动一个线程，控制游戏场景中物体活动（木偶，皮影）
        //固定格式
        //new Tread(){public void run(){...线程需要做的...}}.star();
        new Thread() {
            public void run() {
                //要一直做某事，写一个死循环，让游戏一直运行
                while (true) {
                    if (!gameover) {
                        //调用敌机入场的方法
                        enemyEnter();
                        //调用让敌机移动的方法
                        enemyMove();
                        //这里设置为按空格射击
//                        //发射子弹
//                        shoot();
                        //让子弹飞
                        bulletMove();
                        //判断子弹是否击中敌机
                        shootEnemy();
                        //判断僚机是否捡到金币
                        catchMoney();
                        //让金币飞
                        moneyMove();
                        //判断敌机是否撞到了英雄机
                        hit();
                        //导弹启动
                        if (bombRun) {
                            BombRUN();
                        }
                        //每执行一次，休息一会
                        //线程休眠 sleep(毫秒数)
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //重绘，刷新画布
                    repaint();
                }
            }
        }.start();
    }

    /**
     * 导弹启动
     */
    protected void BombRUN() {
        bomb.run();
        if (!bombHoo && bomb.y >= 250) {
            for (int i = 0; i < ens.size(); i++) {
                Enemy en = ens.get(i);

                int x = en.x;
                int y = en.y;
                //1、敌机死亡（消失：从敌机集合中删除）
                ens.remove(en);
                //生成金币
                Money m = new Money(x, y);
                mon.add(m);
                //击杀数加一
                num += 1;
            }


            bombHoo = true;
            bombRun = false;
        }
        if (bombHoo) {
            Random rd = new Random();
            bomb.x = rd.nextInt(480 - bomb.w);
            bomb.y = -bomb.h;
        }
        bombHoo = false;
    }

    /**
     * 检测敌机是否撞到英雄机
     */
    protected void hit() {
        //遍历敌机
        for (int i = 0; i < ens.size(); i++) {
            //获取敌机
            Enemy e = ens.get(i);
            //如果敌机被英雄机撞到
            if (e.hitBy(hero)) {
                int ensx = e.x;
                int ensy = e.y;
                //1、删除敌机
                ens.remove(e);
                //2、英雄机血量减少
                hero.hp--;
                //3、生成金币
                Money m = new Money(ensx, ensy);
                mon.add(m);
                //4.击杀数加一
                num += 1;
                //5、当英雄机血量清零是游戏结束
                if (hero.hp <= 0) {
                    gameover = true;
                }
            }
            if (e.hitBy(wingman) && !wingmanDie) {
                //1、删除敌机
                ens.remove(e);
                //2、英雄机血量减少
                wingman.hp--;
                //3、增加分数
                score += 1;
                //4、增加击杀数
                num += 1;
                //5、当英雄机血量清零是游戏结束
                if (wingman.hp <= 0) {
                    wingmanDie = true;
                }
            }
        }
    }

    /**
     * 检测僚机是否捡到金币
     */
    protected void catchMoney() {
        //遍历每一个金币，将金币与僚机经行位置比较
        for (int i = 0; i < mon.size(); i++) {
            //获取该敌机
            Money m = mon.get(i);
            //判断该子弹是否击中敌机
            if (m.catchBy(wingman)) {
                //如果金币被僚机捡到
                //1、金币死亡（消失：从敌机集合中删除）
                mon.remove(m);
                //2、分数加一
                score += 1;
            }
        }
    }

    /**
     * 检测子弹是否集中敌机
     */
    protected void shootEnemy() {
        //遍历所有的敌机，不知道是哪一个子弹大到了飞机所以要遍历
        for (int i = 0; i < bul.size(); i++) {
            //获取每一个子弹
            Bullet b = bul.get(i);
            //每拿一颗子弹，就判断一下这颗炸弹是否击中敌机
            ko(b);
        }
    }

    /**
     * 判断子弹是否击中敌机
     */
    private void ko(Bullet b) {
        //遍历每一个敌机，将子弹与敌机经行位置比较
        for (int i = 0; i < ens.size(); i++) {
            //获取该敌机
            Enemy e = ens.get(i);
            //判断该子弹是否击中敌机
            if (e.shootBy(b)) {
                //如果敌机被子弹击中
                //记录死亡位置
                int x = e.x;
                int y = e.y;
                //1、敌机死亡（消失：从敌机集合中删除）
                ens.remove(e);
                //2、删除子弹
                bul.remove(b);
                //生成金币
                Money m = new Money(x, y);
                mon.add(m);
                //击杀数加一
                num += 1;
            }
        }
    }

    /**
     * 让子弹飞
     */
    protected void bulletMove() {
        //遍历所有子弹
        for (int i = 0; i < bul.size(); i++) {
            //获取每一个子弹
            Bullet bullet = bul.get(i);
            //让子弹飞
            bullet.move();
        }
    }

    /**
     * 让金币飞
     */
    protected void moneyMove() {
        for (int i = 0; i < mon.size(); i++) {
            //获取每一个子弹
            Money money = mon.get(i);
            //让子弹飞
            money.move();
        }
    }

    /**
     * 发射子弹的方法
     */
    int bulletNum = 0;//计数器记录shoot方法执行次数

    protected void shoot() {
        bulletNum++;
        if (bulletNum >= 5) {
            //创建子弹
            Bullet bullet1 = new Bullet(hero.x, hero.y);
            //将子弹加入子弹集
            bul.add(bullet1);
            //加入双排子弹
            //创建子弹
            Bullet bullet2 = new Bullet(hero.x + 72, hero.y);
            //将子弹加入子弹集
            bul.add(bullet2);
            //创建子弹
//            Bullet bullet3 = new Bullet(hero.x+36, hero.y-20);
//            //将子弹加入子弹集
//            bul.add(bullet3);
            bulletNum = 0;
        }
    }

    /**
     * 敌机移动的方法
     */
    protected void enemyMove() {
        //遍历所有的敌机
        for (int i = 0; i < ens.size(); i++) {
            //获取每一个敌机
            Enemy en = ens.get(i);
            //敌机移动
            en.move();

        }


    }

    /**
     * 敌机入场的方法
     * 因为此方法在死循环中调用的，所以该方法会一直重复运行
     * 因为敌机数量刷新的太快，我们让执行n次enemyEnter()方法，才创建一个敌机
     */
    int index = 0;//记录方法执行的次数

    protected void enemyEnter() {
        //记录执行次数
        index++;
        if (index >= 15) {
            //1、创建敌机
            Enemy en = new Enemy();
            //2、将敌机加入到敌机集合中
            ens.add(en);
            //将index清零
            index = 0;
        }
    }

    public GamePanel(GameFrame frame) {
        //设置背景
        setBackground(Color.GRAY);

        //初始化图片
        bg = App.getImg("/img/background.png");

        //使用鼠标监听器（固定格式）
        //1、创建鼠标适配器
        MouseAdapter adapter = new MouseAdapter() {
            //2、确定需要监听的鼠标事件
            // 鼠标的事件
            //  mouseMoved() 监听鼠标移动事件
            //  mouseClick() 监听鼠标单击事件
            //  mousePressed() 监听鼠标按下去的事件
            //  mouseEntered() 监听鼠标移入游戏界面事件
            //  mouseExited() 监听鼠标移出游戏界面事件
            // MouseEvent 鼠标的事件，记录鼠标做的事情
            @Override
            public void mouseClicked(MouseEvent e) {
                if (score >= 10 && !gameover && !wingmanDie && wingman.meet(hero) && hero.hp < 3 && e.getButton() == e.BUTTON1) {
                    score -= 10;
                    hero.hp += 1;
                }
                if (score >= 20 && !gameover && !wingmanDie && wingman.meet(hero) && e.getButton() == e.BUTTON3) {
                    bombRun = true;
                    score -= 20;
                }
            }


            @Override
            public void mouseMoved(MouseEvent e) {
                //当鼠标在游戏界面中移动时，会触发的方法
                //让英雄机跟着鼠标一起移动
                //让英雄的横纵坐标等于鼠标的横纵坐标

                //获取鼠标的横纵坐标
                int mx = e.getX();//鼠标的横坐标
                int my = e.getY();//鼠标的纵坐标
                //如果游戏没有结束
                if (!gameover && !wingmanDie) {
                    //让英雄机移动到鼠标的位置上（英雄机的行为，可以在英雄机中定义移动到鼠标的方法）
                    wingman.moveToMouse(mx, my);
                }
                //这里需要注意：
                //要刷新页面，将英雄机绘制到新的位置上
                //重新调用paint方法
                repaint();


            }
        };
        //将适配器加入到监听器中
        addMouseListener(adapter);
        addMouseMotionListener(adapter);


        //使用键盘监听器（固定格式）
        //1、创建键盘适配器
        KeyAdapter kd = new KeyAdapter() {

            //2、确定需要监听的键盘事件
            @Override
            public void keyPressed(KeyEvent e) {
                //当按下键盘的按键时，会触发的方法
                //监听键盘的按键
                //每一个键盘的按键都对应的有一数字

                //获取键盘上按键的数字
                int keyCode = e.getKeyCode();
                //如果按了上键
                if (!gameover) {
                    if (keyCode == KeyEvent.VK_W) {
                        //英雄机向上移动
                        hero.moveUp();

                    } else if (keyCode == KeyEvent.VK_S) {
                        //英雄机向下移动
                        hero.moveDown();
                    } else if (keyCode == KeyEvent.VK_A) {
                        //英雄机向左移动
                        hero.moveLeft();
                    } else if (keyCode == KeyEvent.VK_D) {
                        //英雄机向右移动
                        hero.moveRight();
                    } else if (keyCode == KeyEvent.VK_SPACE) {
                        shoot();
                    }
                } else if (gameover) {
                    if (keyCode == KeyEvent.VK_ENTER) {
                        //重新开始游戏
                        hero = new Hero();
                        wingman = new Wingman();
                        //重置游戏开关
                        gameover = false;
                        score = 0;
                        ens.clear();
                        bul.clear();
                        mon.clear();
                        repaint();
                    }
                }
                //重绘
                repaint();
            }
        };
        //3、将适配器加入到窗体的监听器中
        frame.addKeyListener(kd);

    }

    /**
     * 专用画图方法
     * Graphics g 画笔
     * paint 方法的写法， 先打一个paint出来，然后再按键盘Alt+?
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画图片
        //g.drawImage(图片，图片的横坐标，图片的纵坐标，null)
        //横纵坐标，是设置图片左上角的坐标
//        o———————————————>x
//        |
//        |
//        |
//        |
//        |
//        |y
//         java的坐标
        g.drawImage(bg, 0, 0, null);
        g.drawImage(bg, 480, 0, null);
        //画图片时，如果不加宽度和高度，画的是原图的大小
        //g.drawImage(图片,图片的横坐标,图片的纵坐标,图片的宽度,图片的高度,null);
        //上面操作是在画背景的时候改变图片大小


        //画英雄机
        //g.drawImage(图片,图片的横坐标,图片的纵坐标,图片的宽度,图片的高度,null);
        g.drawImage(hero.img, hero.x, hero.y, hero.w, hero.h, null);

        //画僚机
        if (!wingmanDie) {
            g.drawImage(wingman.img, wingman.x, wingman.y, wingman.w, wingman.h, null);
        }
        //画导弹
        if (!bombHoo && bombRun) {
            g.drawImage(bomb.img, bomb.x, bomb.y, bomb.w, bomb.h, null);
        }
        //画敌机
        //在paint中画图是有顺序的，先画的会被后画的覆盖
        //遍历敌机集合，画出所有的敌机
        for (int i = 0; i < ens.size(); i++) {
            //获取每个敌机
            Enemy e = ens.get(i);
            g.drawImage(e.img, e.x, e.y, e.w, e.h, null);
        }
        //画子弹
        for (int i = 0; i < bul.size(); i++) {
            //获取一个子弹
            Bullet bullet = bul.get(i);
            g.drawImage(bullet.img, bullet.x, bullet.y, bullet.w, bullet.h, null);

        }
        //画金币
        for (int i = 0; i < mon.size(); i++) {
            //获取一个子弹
            Money money = mon.get(i);
            g.drawImage(money.img, money.x, money.y, money.w, money.h, null);

        }
        //画分数
        g.setColor(Color.white);
        g.setFont(new Font("楷体", Font.BOLD, 30));
        g.drawString("金币数：" + score, 10, 30);
        g.drawString("击杀数：" + num, 10, 55);
        g.setColor(Color.red);
        g.setFont(new Font("楷体", Font.BOLD, 15));
        g.drawString("英雄血量：", 220, 25);
        g.drawString("僚机血量：", 220, 50);
        //画英雄机的血量
        for (int i = 0; i < hero.hp; i++) {
            g.drawImage(hero.img, 300 + i * 35, 5, 30, 30, null);
        }
        //画僚机血量
        for (int i = 0; i < wingman.hp; i++) {
            g.drawImage(wingman.img, 300 + i * 35, 30, 30, 30, null);
        }
        //当游戏结束时，画出GameOver
        if (gameover) {
            g.setColor(Color.red);
            g.setFont(new Font("楷体", Font.BOLD, 35));
            g.drawString("Game Over", 20, 300);
            g.setFont(new Font("楷体", Font.BOLD, 20));
            g.drawString("按下enter，让你重返战场", 20, 350);
        }
    }
}
