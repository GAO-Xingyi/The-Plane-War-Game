# Java多人联机游戏（飞机大战)
[飞机大战源码及素材](https://download.csdn.net/download/qq_50459047/20036391)
![在这里插入图片描述](https://img-blog.csdnimg.cn/6197a5bacaa3493db6db04ba249ed29b.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/a0d75eaab2b74c63b96bff006d1feafd.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)

### 一、引言
  应本学期Java课程大作业要求，建立可联机游戏项目。于是便编写了这个游戏。
  关于这款游戏，其想法来源于传统的雷霆战机，然后对这类游戏进行了改造，对其玩法经行了补充。其玩法分为单人、双人、联机模式；在单机单人或双人模式中，由一人控制英雄机，“wsad”键位实现上下左右移动操作、“空格”进行射击，英雄机功能为经行射击攻击，并且为导弹的主要载体。另一人可以控制僚机，通过鼠标移动控制，僚机体积小用鼠标控制，这意味着可以更加灵活的在枪林弹雨中穿梭，其功能是辅助英雄机、提供进攻与防御的支持。僚机的设定中其不能射击攻击，由于英雄机击杀敌机后，会掉落金币，僚机用于拾取这些金币，游戏的初始设定为10金币可以，可以换取英雄机一条命；20金币可以释放大型导弹产生大范围的攻击，但金币在僚机上，需要当僚机与英雄机相重合时可进行这类操作。注意：僚机血量不能回复，且当血量达到上限时（初始设定：英雄机血量为3；僚机血量为5）不能进行加血操作。敌机方面，会从任意位置、任意刷新三种不同种类敌机，（不同敌机移动速度不同，小的敌机移速较快，中等适中，大的则慢）。状态栏设置在上部，左上角显示的是击杀数（当英雄机或僚机撞到敌机是会击杀敌机，但会损失血量）与金币数；右上角显示英雄机与僚机血量。当英雄机阵亡后游戏结束，“enter”键可以重返战场，当数据会初始化。联机模式就是可以在不同的端口同时运行该游戏经行竞技，然后可以经行数据的交互，击杀数高者为胜者。
### 二、游戏框架与类
#### 1、类图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210705015544824.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021070501560754.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)
#### 2.类
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210705015826355.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210705015851350.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210705015928642.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210705020012809.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210705020127477.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210705020148545.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)
### 三、代码实现
#### App
在整个工程开始之前，由于我们需要实现游戏图形化，所以我们需要把图像导入，为了避免导入图片时不用重复操作，这也就需要我们有一个导入图片的工具，我就新建了一个App类。
  首先我们要了解Java中的表示图片的类是BufferedImage，我们就要定义一个BufferedImage的方法用以调用图片（getImg()）,通过IO流读取到相应图片，在将图片导入。搭建一个反射框架来执行待操作。
```javascript
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class App {
    //读取指定位置上的图片
    //加static的目的：
    //static特点：公用的，所有对象，可以直接通过类名调用（不需要再调用对象）
    public static BufferedImage getImg(String path){
        //加载图片
        //Java中的IO流，输送数据的管道
        //输入输出流
        //这里利用反射，提前构造好框架
        //App.class 找到App类的路径
        //getResource()获取资源
        try {
            BufferedImage img = ImageIO.read(App.class.getResource(path));
            //如果找到图片，就将图片返回
            return img;
        } catch (IOException e){
            //catch 如果找不到图片，就会捕获找不到图片的原因
            e.printStackTrace();
        }
        return null;
    }
}
```
有了图形导入工具以后，我们就可以开始进行游戏中对象类的编写了。我们的游戏是飞机大战，其中元素对象为：英雄机、僚机、敌机、子弹、导弹、金币。这些类都有一定的特性。于是，我们创建一个关于这些飞行物的一个超类（flyObject），由这些子类来继承。
#### flyObject
这个超类中需要放一些共用的变量，该飞行物的所在的位置坐标（横纵坐标），以及该飞行物的高度与宽度，以及飞行物的图片。
```javascript
import java.awt.image.BufferedImage;
public class flyObject {
    //飞行物的图片
    BufferedImage img ;
    //飞行物的横坐标
    int x;
    //飞行物的纵坐标
    int y;
    //飞行物的宽度
    int w;
    //飞行物的高度
    int h;


}

```
#### Hero
定义完飞行物超类后我们就可以将这些对象类一一编写出来。英雄机，这里我们需要做的就是导入英雄机的图片并获取图片的长高。用以确定英雄机的初始位置。另外，我们要新增英雄机血量参数，并为其编写上下左右的移动方法。
```javascript
public class Hero extends flyObject {
    int hp;
    public Hero(){
        //确定游戏开始时，英雄机显示的图片
        img = App.getImg("/img/hero.png");
        //确定英雄机的大小
        //使用图片的大小，作为飞机的大小
        w=img.getWidth();
        h=img.getHeight();
        //使用横纵坐标、确定英雄机在游戏开始时显示的位置
        x=175;
        y=650-h;
        hp = 3;//英雄机的初始血量

    }
 //向上移动
    public void moveUp(){
        if(y>=50)
        y -= 50;
    }
    //向下移动
    public void moveDown(){
        if(y<=530)
        y += 50;
    }
    //向左移动
    public void moveLeft(){
        if(x>=25)
        x -=50;
    }
    //向右移动
    public  void moveRight(){
        if(x<=335)
        x += 50;
    }


}

```
#### Wingman
僚机类与英雄机类相似，但由于其是通过鼠标移动，所以需要将鼠标的位置参数传给僚机图片的正中央位置的参数，所以要新建一个含参方法moveToMouse(int mx int my)其中的参数就为鼠标的位置参数。而且由于僚机功能的原因，当他登上英雄机时才能进行兑换金币用以补血与使用导弹的操作，我们还需要一个方法（meet）去判定来哦及是否与英雄机重合。
```javascript
public class Wingman extends flyObject{
    int hp;
    public Wingman(){
        img = App.getImg("/img/wingman.png");
        w=img.getWidth();
        h=img.getHeight();
        x=300;
        y=600-h;
        hp = 5;
    }
    public void moveToMouse(int mx, int my){
        x = mx-w/2;//将鼠标居于僚机正中
        y = my-h/2;//将鼠标居于僚机正中
    }

    /**
     * 检测是否达到加血要求
     */
    public boolean meet(Hero hero) {
        boolean meetH = x <= hero.x + hero.w && x >= hero.x - w && y <= hero.y + hero.h && y >= hero.y - h;
        return meetH;
    }
}
```
#### Enemy
敌机类中，我设置的有三种不同类型的敌机，分为大、中、小，我们要分别随机的刷入敌机种类与随机生成位置，并且不同的飞机类型拥有不同的飞行速度，我采取的方法是设置1-3标签，然后随机在1-3中抽取，对图片也同样进行编号，速度的表示用一定大的数减去标签数与适配值的积。于是，飞机越大，标签值越大，速度也就越慢。我们还要将速度这一参量体现在飞机的移动中。并且，我们还要设置敌机的碰撞条件判定。
Java画板绘图时采取的坐标系如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210705210353346.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)

范围判定如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210705205017395.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzUwNDU5MDQ3,size_16,color_FFFFFF,t_70)
飞行物的位置坐标是取其图片的左上角，所以当敌机位置横坐标小于等于飞行物横坐标与飞行物宽度之和，且大于等于飞行物的位置横坐标与敌机宽度之差；敌机位置纵坐标小于等于飞行物位置纵坐标与其高度之和，敌机位置纵坐标大于等于飞行物位置纵坐标与敌机的高度之差的时候，判定为碰撞。
所以我们用写作：x <= f.x + f.w && x >= f.x - w && y <= f.y + f.h && y >= f.y - h
然后，因为敌机与子弹、英雄机、僚机相撞均会毁坏，所以我们要将该方法进行重写。
```javascript
import java.util.Random;
public class Enemy extends flyObject {

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
        boolean hitH = x <= he.x + he.w && x >= he.x - w && y <= he.y + he.h && y >= he.y-h;
        return hitH;
    }
    public boolean hitBy(Wingman he) {
        boolean hitH = x <= he.x + he.w && x >= he.x - w && y <= he.y + he.h && y >= he.y-h;
        return hitH;
    }
}
```
#### Money、Bomb和Bullet
有了刚刚几个类的基础，这几个类也是如法炮制的，只是需要注意的是Money类需要编写一个判定僚机拾取的方法，那么这几个类就留给读者自行练习用吧。

#### GameFrame
 在对象类完成以后，我们继而需要做出游戏窗口的边框与面板，GameFrame类继承JFrame，再在构造函数里经行一些基础属性的设置
 ```j
 import javax.swing.*;
public class GameFrame extends JFrame {

    public GameFrame(){
        //设置标题 方法源于JFrame类
        setTitle("飞机大战");
        //设置大小  setSize(宽度，高度)
        setSize(480,700);
        //设置居中显示  null表示相对与屏幕左上角居中
        setLocationRelativeTo(null);
        //设置不允许玩家改变界面大小
        setResizable(false);
        //设置默认的关闭选项
        //关闭窗体时推出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
```
我们再这里也加入main函数，并创建窗体对象与面板对象，并将面板加入到窗体中。
```j
public static void main(String[] args) {
        //创建窗体对象：调用窗体的构造方法，制作窗体
        GameFrame frame = new GameFrame();
        //创建面板对象：调用面板的构造方法，制作面板
        GamePanel panel =new GamePanel(frame);//方便在面板中添加键盘监听器
        //调用启动游戏的方法
        panel.startGame();
        //将面板加入到窗体中
        frame.add(panel);
        //显示窗体 true 显示， false 隐藏
        frame.setVisible(true);


    }
}
```
#### GamePanel
GamePanel是游戏面板类，也是承建游戏机制逻辑的主体。首先我们要将对象创建进来，因为敌机，子弹和金币需要不断刷新多个实例，所以我们给这几个类创建链表。我们还要创建线程，在线程里，执行相应方法，然后就是书写方法。创建鼠标键盘适配器，然后再写监听方法。并定义画笔，将背景，状态栏及对象绘制出来。这是大致的流程。
```j
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Java中的游戏面板： JPanel
 * 自定义游戏面板
 * 1、写一个类，继承JPanel
 * 2、写一个构造方法，初始化（确定）面板的属性
 *
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
    int score=0;
    //定义击杀量
    int num=0;
    //设置游戏开关
    boolean gameover;//游戏开始时gameover为false
    boolean wingmanDie;
    boolean bombHoo=false;
    boolean bombRun=false;
    /**
     * 开始游戏的方法
     */
    public void startGame(){
        //创建并启动一个线程，控制游戏场景中物体活动（木偶，皮影）
        //固定格式
        //new Tread(){public void run(){...线程需要做的...}}.star();
        new Thread(){
            public void run(){
                //要一直做某事，写一个死循环，让游戏一直运行
                while(true){
                    if(!gameover) {
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
                        if(bombRun){
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
    protected void BombRUN(){
        bomb.run();
        if(!bombHoo && bomb.y>=250){
            for(int i=0;i<ens.size();i++) {
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


            bombHoo=true;
            bombRun=false;
        }
        if(bombHoo){
            Random rd = new Random();
            bomb.x= rd.nextInt(480 - bomb.w);
            bomb.y = -bomb.h;
        }
        bombHoo=false;
    }

    /**
     * 检测敌机是否撞到英雄机
     */
    protected void hit(){
        //遍历敌机
        for(int i=0;i<ens.size();i++){
            //获取敌机
            Enemy e=ens.get(i);
            //如果敌机被英雄机撞到
            if(e.hitBy(hero)){
                int ensx=e.x;
                int ensy=e.y;
                //1、删除敌机
                ens.remove(e);
                //2、英雄机血量减少
                hero.hp--;
                //3、生成金币
                Money m = new Money(ensx,ensy);
                mon.add(m);
                //4.击杀数加一
                num+=1;
                //5、当英雄机血量清零是游戏结束
                if(hero.hp<=0){
                    gameover = true;
                }
            }
            if(e.hitBy(wingman) && !wingmanDie){
                //1、删除敌机
                ens.remove(e);
                //2、英雄机血量减少
                wingman.hp--;
                //3、增加分数
                score+=1;
                //4、增加击杀数
                num+=1;
                //5、当英雄机血量清零是游戏结束
                if(wingman.hp<=0){
                    wingmanDie=true;
                }
            }
        }
    }
    /**
     * 检测僚机是否捡到金币
     */
    protected  void catchMoney(){
        //遍历每一个金币，将金币与僚机经行位置比较
        for(int i=0;i<mon.size();i++){
            //获取该敌机
            Money m = mon.get(i);
            //判断该子弹是否击中敌机
            if(m.catchBy(wingman)){
                //如果金币被僚机捡到
                //1、金币死亡（消失：从敌机集合中删除）
                mon.remove(m);
                //2、分数加一
                score+=1;
            }
        }
    }
    /**
     * 检测子弹是否集中敌机
     */
    protected void shootEnemy(){
        //遍历所有的敌机，不知道是哪一个子弹大到了飞机所以要遍历
        for(int i=0;i<bul.size();i++){
            //获取每一个子弹
            Bullet b = bul.get(i);
            //每拿一颗子弹，就判断一下这颗炸弹是否击中敌机
            ko(b);
        }
    }

    /**
     *判断子弹是否击中敌机
     */
    private void ko(Bullet b){
        //遍历每一个敌机，将子弹与敌机经行位置比较
        for(int i=0;i<ens.size();i++){
            //获取该敌机
            Enemy e = ens.get(i);
            //判断该子弹是否击中敌机
            if(e.shootBy(b)){
                //如果敌机被子弹击中
                //记录死亡位置
                int x=e.x;
                int y=e.y;
                //1、敌机死亡（消失：从敌机集合中删除）
                ens.remove(e);
                //2、删除子弹
                bul.remove(b);
                //生成金币
                Money m = new Money(x,y);
                mon.add(m);
                //击杀数加一
                num+=1;
            }
        }
    }

    /**
     * 让子弹飞
     */
    protected  void bulletMove(){
        //遍历所有子弹
        for(int i=0; i<bul.size();i++){
            //获取每一个子弹
            Bullet bullet = bul.get(i);
            //让子弹飞
            bullet.move();
        }
    }
    /**
     * 让金币飞
     */
    protected  void moneyMove(){
        for(int i=0; i<mon.size();i++){
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
    protected void shoot(){
        bulletNum++;
        if(bulletNum>=5 ) {
            //创建子弹
            Bullet bullet1 = new Bullet(hero.x, hero.y);
            //将子弹加入子弹集
            bul.add(bullet1);
            //加入双排子弹
            //创建子弹
            Bullet bullet2 = new Bullet(hero.x+72, hero.y);
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
    protected void enemyMove(){
        //遍历所有的敌机
        for(int i=0;i<ens.size();i++){
            //获取每一个敌机
            Enemy en =ens.get(i);
            //敌机移动
            en.move();

        }


    }
    /**
     * 敌机入场的方法
     * 因为此方法在死循环中调用的，所以该方法会一直重复运行
     * 因为敌机数量刷新的太快，我们让执行n次enemyEnter()方法，才创建一个敌机
     */
    int index= 0 ;//记录方法执行的次数
    protected void enemyEnter(){
        //记录执行次数
        index ++;
        if(index>=15) {
            //1、创建敌机
            Enemy en = new Enemy();
            //2、将敌机加入到敌机集合中
            ens.add(en);
            //将index清零
            index = 0;
        }
    }

    /**
     * 返回分数与击杀数的函数
     * @param frame
     * @return
     */
    public int returnScore(){
        final int score = this.score;
        return score;
    }

    public int returnNum(){
        return num;
    }

    public GamePanel(GameFrame frame){
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
            public void mouseClicked(MouseEvent e){
               if(score>=10 && !gameover && !wingmanDie && wingman.meet(hero) && hero.hp<3 && e.getButton()==e.BUTTON1){
                   score-=10;
                   hero.hp+=1;
               }
               if(score>=20 && !gameover && !wingmanDie && wingman.meet(hero) && e.getButton()==e.BUTTON3){
                 bombRun = true;
                 score-=20;
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
                if(!gameover && !wingmanDie) {
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
            public void keyPressed (KeyEvent e) {
                //当按下键盘的按键时，会触发的方法
                //监听键盘的按键
                //每一个键盘的按键都对应的有一数字

                //获取键盘上按键的数字
                int keyCode = e.getKeyCode();
                //如果按了上键
                if(!gameover){
                    if(keyCode==KeyEvent.VK_W){
                        //英雄机向上移动
                        hero.moveUp();

                    }else if(keyCode==KeyEvent.VK_S){
                        //英雄机向下移动
                        hero.moveDown();
                    }else if(keyCode==KeyEvent.VK_A){
                        //英雄机向左移动
                        hero.moveLeft();
                    }else if(keyCode==KeyEvent.VK_D){
                        //英雄机向右移动
                        hero.moveRight();
                    }else if(keyCode==KeyEvent.VK_SPACE){
                        shoot();
                    }
                }else if(gameover){
                    if(keyCode==KeyEvent.VK_ENTER){
                        //重新开始游戏
                        hero = new Hero();
                        wingman = new Wingman();
                        //重置游戏开关
                        gameover = false;
                        score=0;
                        num=0;
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
        g.drawImage(bg, 0, 0,null);
        g.drawImage(bg,480,0,null);
        //画图片时，如果不加宽度和高度，画的是原图的大小
        //g.drawImage(图片,图片的横坐标,图片的纵坐标,图片的宽度,图片的高度,null);
        //上面操作是在画背景的时候改变图片大小


        //画英雄机
        //g.drawImage(图片,图片的横坐标,图片的纵坐标,图片的宽度,图片的高度,null);
        g.drawImage(hero.img,hero.x,hero.y,hero.w,hero.h,null);

        //画僚机
        if(!wingmanDie){
            g.drawImage(wingman.img,wingman.x,wingman.y,wingman.w,wingman.h,null);
        }
        //画导弹
        if(!bombHoo && bombRun){
            g.drawImage(bomb.img,bomb.x,bomb.y,bomb.w,bomb.h,null);
        }
        //画敌机
        //在paint中画图是有顺序的，先画的会被后画的覆盖
        //遍历敌机集合，画出所有的敌机
        for(int i=0;i<ens.size();i++) {
            //获取每个敌机
            Enemy e = ens.get(i);
            g.drawImage(e.img, e.x, e.y, e.w, e.h, null);
        }
        //画子弹
        for(int i=0;i<bul.size();i++){
            //获取一个子弹
            Bullet bullet = bul.get(i);
            g.drawImage(bullet.img,bullet.x,bullet.y,bullet.w,bullet.h,null);

        }
        //画金币
        for(int i=0;i<mon.size();i++){
            //获取一个子弹
            Money money = mon.get(i);
            g.drawImage(money.img,money.x,money.y,money.w,money.h,null);

        }


        //画分数
        g.setColor(Color.white);
        g.setFont(new Font("楷体",Font.BOLD,30));
        g.drawString("金币数："+score,10,30);
        g.drawString("击杀数："+num,10,55);
        g.setColor(Color.red);
        g.setFont(new Font("楷体",Font.BOLD,15));
        g.drawString("英雄血量：",220,25);
        g.drawString("僚机血量：",220,50);
        //画英雄机的血量
        for(int i = 0;i<hero.hp;i++){
            g.drawImage(hero.img,300+i*35,5,30,30,null);
        }
        //画僚机血量
        for(int i = 0;i<wingman.hp;i++){
            g.drawImage(wingman.img,300+i*35,30,30,30,null);
        }
        //当游戏结束时，画出GameOver
        if(gameover) {
            g.setColor(Color.red);
            g.setFont(new Font("楷体", Font.BOLD, 35));
            g.drawString("Game Over", 20, 300);
            g.setFont(new Font("楷体",Font.BOLD,20));
            g.drawString("按下enter，让你重返战场",20,350);
        }
    }
}
```
### 多人联机的实现
使用Socket实现联机，要分别建立服务端（Server）与客户端（Client），并分别建立监听，发送方法
#### Server
```j
import code.GameFrame;
import code.GamePanel;
import org.json.simple.JSONObject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    public static void main(String[] args){
        try {
            System.out.println("Socket 准备就绪...");
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new Server_listen(socket)).start();
                new Thread(new Server_send(socket)).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
class Server_listen implements Runnable {
    private Socket socket;

    Server_listen(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true)
                System.out.println(ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
    class Server_send implements Runnable{
        private Socket socket;
        Server_send(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Scanner scanner = new Scanner(System.in);
//            while (true){
                //创建窗体对象：调用窗体的构造方法，制作窗体
                GameFrame frame = new GameFrame();
                //创建面板对象：调用面板的构造方法，制作面板
                GamePanel panel = new GamePanel(frame);//方便在面板中添加键盘监听器
                //调用启动游戏的方法
                panel.startGame();
                //将面板加入到窗体中
                frame.add(panel);
                //显示窗体 true 显示， false 隐藏
                frame.setVisible(true);
                while (true) {
                    int score = panel.returnScore();
                    int num = panel.returnNum();
                    JSONObject object = new JSONObject();
                    object.put("敌方分数:",score);
                    object.put("敌方击杀数:",num);
                    oos.writeObject(object);
                    oos.flush();
                }

//            }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


```
#### Client
```j
import code.GameFrame;
import code.GamePanel;
import org.json.simple.JSONObject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;
    public static boolean connection_state = false;

    public static void main(String[] args){
        while (!connection_state) {
            connect();
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static void connect(){
        try {
            socket = new Socket("Server的ip", 9999);
            connection_state = true;
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            new Thread(new Client_listen(socket,ois)).start();
            new Thread(new Client_send(socket,oos)).start();
//            new Thread(new Client_heart(socket,oos)).start();
        }catch (Exception e){
            e.printStackTrace();
            connection_state = false;
        }
    }

    public static void reconnect(){
        while (!connection_state){
            System.out.println("正在尝试重新链接.....");
            connect();
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Client_listen implements Runnable{
    private Socket socket;
    private ObjectInputStream ois;

    Client_listen(Socket socket,ObjectInputStream ois){
        this.socket = socket;
        this.ois = ois;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println(ois.readObject());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Client_send implements Runnable{
    private Socket socket;
    private ObjectOutputStream oos;

    Client_send(Socket socket, ObjectOutputStream oos){
        this.socket = socket;
        this.oos = oos;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
//            while (true){
                //创建窗体对象：调用窗体的构造方法，制作窗体
                GameFrame frame = new GameFrame();
                //创建面板对象：调用面板的构造方法，制作面板
                GamePanel panel =new GamePanel(frame);//方便在面板中添加键盘监听器
                //调用启动游戏的方法
                panel.startGame();
                //将面板加入到窗体中
                frame.add(panel);
                //显示窗体 true 显示， false 隐藏
                frame.setVisible(true);
            while (true){
                int score = panel.returnScore();
                int num = panel.returnNum();
                JSONObject object = new JSONObject();
                object.put("敌方分数:",score);
                object.put("敌方击杀数:",num);
                oos.writeObject(object);
                oos.flush();
            }
//            }
        }catch (Exception e){
            e.printStackTrace();
            try {
                socket.close();
                Client.connection_state = false;
                Client.reconnect();
            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
    }
}

```
##### 这就是该游戏的全部内容，游戏素材可以在网上搜索，这里也提供一份全套资源（含源码和素材）[飞机大战源码及素材](https://download.csdn.net/download/qq_50459047/20036391)
