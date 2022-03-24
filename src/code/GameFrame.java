package code;

import javax.swing.*;


/**
 * 游戏的窗体（固定的模式）
 * Java中的窗体类：JFrame
 * 自定义窗体步骤：
 * 1、写一个类，继承JFrame
 * 2、写一个构造方法，初始化窗体的属性
 * 属性对应特点，方法对应行为
 */
public class GameFrame extends JFrame {
    /*
    构造方法：方法名和类名一样
    构造方法的作用：如同模具，给对象定型
     */
    public GameFrame() {
        //设置标题 方法源于JFrame类
        setTitle("飞机大战");
        //设置大小  setSize(宽度，高度)
        setSize(480, 700);
        //设置居中显示  null表示相对与屏幕左上角居中
        setLocationRelativeTo(null);
        //设置不允许玩家改变界面大小
        setResizable(false);
        //设置默认的关闭选项
        //关闭窗体时推出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
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


    }
}
